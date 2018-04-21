import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class MetadefenderCore {

    Map<String, String> map = new HashMap<String, String>();
    JSONObject jsonobject;
    private final OpswatApis apis;
    retrieveData rd;
    Hash newHash;

    public MetadefenderCore(OpswatApis apis) {
        this.apis = apis;
        this.rd = new retrieveData(this.apis);
        this.newHash = new Hash(this.apis);
    }

    public String validating(String filePath, String dataId) throws ParseException {

        if (!map.containsKey(filePath)) {
            //upload the file
            uploadFile upload = new uploadFile(apis);
            try {
                jsonobject = upload.upload(filePath);
                System.out.println("Upload results " + jsonobject);
                dataId = (String) jsonobject.get("data_id");
                String hash = rd.retrieve(dataId);
                map.put(filePath, hash);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                String hash = map.get(filePath);
                JSONObject results = newHash.retrieveHash(hash);
                System.out.println(" Results " + results);
                for (int i = 0; i < results.size(); i++) {
                    String thread_found = (String) results.get("thread_found");
                    String scan_result = (String) results.get("scan_result");
                    String def_time = (String) results.get("def_time");
                    System.out.println("thread_found: " + thread_found);
                    System.out.println("scan_result: " + scan_result);
                    System.out.println("def_time: " + def_time);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return dataId;
    }

}

