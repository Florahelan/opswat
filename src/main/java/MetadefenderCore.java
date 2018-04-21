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

    public void validating(String filePath, String dataId) throws ParseException {
        if (!map.containsKey(filePath)) {
            //upload the file
            uploadFile upload = new uploadFile(apis);
            try {
                //jsonobject = upload.upload(filePath);
                //dataId = (String) jsonobject.get("data_id");
                dataId = "cDE4MDQyMUgxRngxbXhadTN6U3k1eHlRZVpkMmY";
                String hash = rd.retrieve(dataId);
                map.put(filePath, hash);

            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                String hash = map.get(filePath);
                JSONObject results = null;
                results = newHash.retrieveHash(hash);
                System.out.println(" Result in metadefendercore is: " + results);
                System.out.println("size is: " + results.size());
                ScanReport report = new ScanReport(results);
                report.display();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

