import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Response;

public class retrieveData {

    final static ApiKey API_KEY = Utils.retrieveApiKey();
    private final OpswatApis apis;

    public retrieveData(OpswatApis apis) {
        this.apis = apis;
    }

    public String retrieve(String dataId) throws IOException, ParseException {
        Call<String> requestCall = apis.retrieveDataId(dataId, API_KEY);
        Response<String> serverResponse = requestCall.execute();
        JSONParser parser = new JSONParser();
        JSONObject jsonObject = (JSONObject) parser.parse(serverResponse.body());
        //JSONObject fileinfo = (JSONObject) jsonObject.get("file_info");

        //String sha256 = (String) fileinfo.get("sha256");
        String sha256="6AB4B257CEEE769715A5F10BF9B8215608B2EF0A57F35E8D14CEDD28AFC0DA33";
        if (sha256 == null || sha256.length() == 0) {
            sha256 = retrieve(dataId);
        }
        System.out.println(" Result is:" + jsonObject);
        return sha256;
    }
}
