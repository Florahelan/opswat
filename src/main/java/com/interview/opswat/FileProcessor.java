package com.interview.opswat;

import com.google.gson.Gson;
import com.interview.opswat.models.FileInfo;
import com.interview.opswat.models.HashWrapper;
import com.interview.opswat.models.ScanResults;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;

/**
 * The central class which takes care of the retreiving the results of a particular file given to upload.
 */
public class FileProcessor {

    private ApiKey API_KEY = Utils.retrieveApiKey();
    private Map<String, String> cache;
    private OpswatApiClient apiClient;
    private Gson gson;
    private JSONParser jsonParser;
    private ApiExceptions apiExceptions;

    public FileProcessor(OpswatApiClient apiClient) {
        this.apiClient = apiClient;
        cache = new HashMap<String, String>();
        jsonParser = new JSONParser();
        apiExceptions = new ApiExceptions();
        gson = new Gson();
    }

    /**
     * The main method which does the following functionalities
     *
     * 1. Given a file , checks if there is a hash for the file already existing. If it does it retrieves the hash
     * and hits the lookupResultsByHash api to get the scan results.
     * 2. If the hash is not found the file is uploaded, and the dataId for the file is retrieved . This data Id is
     * then used to retrieve the hash and the final results by hitting the lookupResultsByDataId api .
     *
     * @param filePath the file path
     * @return the Scan report.
     * @throws Exception any exception.
     */
    public ScanReport generateResults(File filePath) throws Exception {
        if (!cache.containsKey(filePath.getPath())) {
            //uploadFile the file
            System.out.println("Cannot find File hash in cache, Uploading File ..");
            JSONObject jsonobject = uploadFile(filePath);
            String dataId = (String) jsonobject.get("data_id");
            String hash = retrieveHash(dataId);
            cache.put(filePath.getPath(), hash);
            return getResultsFromHash(hash);
        } else {
            String hash = cache.get(filePath.getPath());
            return getResultsFromHash(hash);
        }
    }

    /*
     * It retrieves the hash given the dataId
     */
    private String retrieveHash(String dataId) throws Exception {
        String sha256;
        Call<String> requestCall = apiClient.retrieveDataId(dataId, API_KEY);
        Response<String> serverResponse = requestCall.execute();
        if (serverResponse.isSuccessful()) {
            String responseFromServer = serverResponse.body();
            HashWrapper hashWrapper = gson.fromJson(responseFromServer, HashWrapper.class);
            FileInfo fileinfo = hashWrapper.getFileInfo();
            sha256 = fileinfo.getSha256();
            ScanResults results = hashWrapper.getScanResults();
            Integer progressPercent = results.getProgressPercentage();
            System.out.println(" Scan Progress " + progressPercent);
            if (sha256 == null || sha256.length() == 0 || progressPercent < 99) {
                sha256 = retrieveHash(dataId);
            }
        } else {
            int responseCode = serverResponse.code();
            throw new Exception(apiExceptions.getExceptionString(responseCode));
        }
        return sha256;
    }

     /*
     * It retrieves the Scan Report given the Hash.
     */
    private ScanReport getResultsFromHash(String hash) throws Exception {
        Call<String> requestCall = apiClient.retrieveHash(hash, API_KEY);
        Response<String> serverResponse = requestCall.execute();
        if (serverResponse.isSuccessful()) {
            String serverSentResponse = serverResponse.body();
            JSONObject json = (JSONObject) jsonParser.parse(serverSentResponse);
            return new ScanReport(json);
        } else {
            int responseCode = serverResponse.code();
            throw new Exception(apiExceptions.getExceptionString(responseCode));
        }
    }


    /*
     * The method uploads the given file to the remote server.
     */
    private JSONObject uploadFile(File fileRef) throws Exception {
        if (!fileRef.exists()) {
            throw new IOException(" The File Path is not found " + fileRef.getAbsolutePath());
        }
        String mimeType = fileRef.toURL().openConnection().getContentType();
        String fileName = fileRef.getName();

        System.out.println("Uploading .. ");

        System.out.println("File Name " + fileName);
        System.out.println("Mime type " + mimeType);

        RequestBody requestbody = RequestBody.create(MediaType.parse(mimeType), fileRef);
        Call<String> requestCall = apiClient.uploadFile(API_KEY, fileName, requestbody);
        Response<String> serverResponse = requestCall.execute();
        if (serverResponse.isSuccessful()) {
            return (JSONObject) jsonParser.parse(serverResponse.body());
        } else {
            int responseCode = serverResponse.code();
            if (responseCode != 200) {
                throw new Exception(apiExceptions.getExceptionString(responseCode));
            }
            return null;
        }
    }
}
