package com.interview.opswat;

import org.json.simple.JSONObject;

import java.util.Iterator;

/**
 * Scan report is dispalyed from the retrieveResults by hash json object
 */

public class ScanReport {

    private final JSONObject results;

    ScanReport(JSONObject results) {
        this.results = results;
    }

    public void display() {
        JSONObject scanResults = (JSONObject) results.get("scan_results");
        JSONObject scanDetails = (JSONObject) scanResults.get("scan_details");
        JSONObject fileinfo = (JSONObject) results.get("file_info");
        String status = (String) scanResults.get("scan_all_result_a");
        System.out.println("filename: " + (String)fileinfo.get("display_name"));
        String clean = "No threat detected";
        String infected = "threat found";
        if (status.equals(clean)) {
            System.out.println("overall_status: " + "Clean");
        } else if (status.equals(infected)) {
            System.out.println("overall_status: " + "Infected");
        }
        System.out.println("\n");
        Iterator iterator = scanDetails.keySet().iterator();
        while (iterator.hasNext()) {
            String engine = (String) iterator.next();
            System.out.println("engine: " + engine);
            JSONObject threatEngine = (JSONObject) scanDetails.get(engine);
            System.out.println("threat_found: " + (String) threatEngine.get("threat_found"));
            System.out.println("scan_result: " + (Long) threatEngine.get("scan_result_i"));
            System.out.println("def_time: " + (String) threatEngine.get("def_time"));
            System.out.println("\n");
        }

    }
}

