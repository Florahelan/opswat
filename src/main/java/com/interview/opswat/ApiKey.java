package com.interview.opswat;

//Creates an instance for APIKey
public class ApiKey {

    public final String api_key;

    public ApiKey(String key) {
        this.api_key = key;
    }

    @Override
    public String toString() {
        return api_key;
    }
}
