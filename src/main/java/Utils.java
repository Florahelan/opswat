import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;


public class Utils {

    //This class takes care of reading the api.json file and retrieving the api key .
    public static ApiKey retrieveApiKey() {
        try {
            Gson gson = new Gson();
            ApiKey api = gson.fromJson(new FileReader(
                            "/Users/florahelan/Documents/Intellij_Programs/Interview/src/main/resources/api.json"),
                    ApiKey.class);
            return api;
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}



