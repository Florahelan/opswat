import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;

public class uploadFile {
    final static ApiKey API_KEY = Utils.retrieveApiKey();
    private final OpswatApis apis;

    public uploadFile(OpswatApis apis) {
        this.apis = apis;
    }

    public JSONObject upload(String path) throws IOException, ParseException {
        System.out.println("path is: "  + path);
        File fileRef = new File(path);
        if(!fileRef.exists()) {
            throw new IOException(" The File Path is not found " + fileRef.getAbsolutePath());
        }
        //todo get the MediaType from the file
        RequestBody requestbody = RequestBody.create(MediaType.parse("text/plain"), fileRef);
        Call<String> requestCall = apis.uploadFile(API_KEY, requestbody);
        Response<String> serverResponse = requestCall.execute();
        System.out.println("server response is: " + serverResponse.body());
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(serverResponse.body());
        return json;
    }
}
