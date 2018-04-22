package com.interview.opswat;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileReader;


public class Utils {

    /**
     * Reads api.json file and retrieves the api key
     *
     * @return apikey
     */

    public static ApiKey retrieveApiKey() {
        try {
            Gson gson = new Gson();
            ApiKey apiKey = gson.fromJson(new FileReader(
                            "src/main/resources/api.json"),
                    ApiKey.class);
            return apiKey;
        } catch (FileNotFoundException ex) {
            System.out.println("File Not found! Try again");
            ex.printStackTrace();
        }
        return null;
    }
}



