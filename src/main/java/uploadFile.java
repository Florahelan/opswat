import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.Response;


/**
 * This class uploaded the file and JsonObject is returned with the dataId
 */
public class uploadFile {
    final static ApiKey API_KEY = Utils.retrieveApiKey();
    private final OpswatApis apis;

    public uploadFile(OpswatApis apis) {
        this.apis = apis;
    }

    public JSONObject upload(File filePath) throws IOException, ParseException {
        System.out.println("path is: "  + filePath);

        if(!filePath.exists()) {
            throw new IOException(" The File Path is not found " + filePath.getAbsolutePath());
        }
        //todo get the MediaType from the file
        RequestBody requestbody = RequestBody.create(MediaType.parse("text/plain"), filePath);
        Call<String> requestCall = apis.uploadFile(API_KEY, requestbody);
        Response<String> serverResponse = requestCall.execute();
        System.out.println("server response is: " + serverResponse.body());
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(serverResponse.body());
        return json;
    }
}
