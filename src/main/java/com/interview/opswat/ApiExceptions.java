package com.interview.opswat;

import java.util.HashMap;
import java.util.Map;

public class ApiExceptions {

    Map<Integer, String> map = new HashMap<Integer, String>();
    String unknownError = "UnknownError";

    ApiExceptions() {
        initializeMap();
    }

    public void initializeMap() {
        map.put(400, "Bad request, Server could not understand the request");
        map.put(401, "Unauthorized, user trying to access the resource has not been authenticated");
        map.put(403, "valid request but the server is refusing to serve the request");
        map.put(404, "Not Found error, server is unable to locate the requested file or resource");
        map.put(500, "Internal Server Error, server cannot process the request for an unknown reason");
        map.put(503, "Service Unavailable error,server is overloaded or under maintenance");
    }

    /**
     * The method takes the response code and returns the Error String .
     *
     * @param responseCode the response code that is sent from the server
     * @return
     */
    public String getExceptionString(int responseCode) {
        if (map.containsKey(responseCode)) {
            return map.get(responseCode);
        }
        return unknownError;
    }

}
