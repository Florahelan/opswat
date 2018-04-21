import org.json.simple.JSONObject;

import java.util.Iterator;

public class ScanReport {

    private final JSONObject results;

    ScanReport(JSONObject results) {
        this.results = results;
    }

    public void display() {
        System.out.println("filename: " + (JSONObject) results.get("display_name"));

        String status=(String)results.get("scan_all_result_a");

        if(status=="No threat detected"){
            System.out.println("overall_status: " + "Clean" );
        }else {
            System.out.println("overall_status: " + "Infected" );
        }
        JSONObject scanResults = (JSONObject) results.get("scan_results");
        JSONObject scanDetails = (JSONObject) scanResults.get("scan_details");
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

