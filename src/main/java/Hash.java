import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class Hash {

    final static ApiKey API_KEY = Utils.retrieveApiKey();

    private final OpswatApis apis;

    public Hash(OpswatApis apis) {
        this.apis = apis;
    }

    public JSONObject retrieveHash(String hash) throws IOException, ParseException {
        Call<String> requestCall = apis.retrieveHash(hash, API_KEY);
        Response<String> serverResponse = requestCall.execute();
        String serverSentResponse =  serverResponse.body();
        JSONParser parser = new JSONParser();
        JSONObject json = (JSONObject) parser.parse(serverResponse.body());
        return json;
    }

}
