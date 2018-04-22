import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//
public class MetadefenderCore {

    Map<String, String> map = new HashMap<String, String>();
    JSONObject jsonobject;
    private final OpswatApis apis;
    retrieveData rd;
    DataHash newDataHash;


    public MetadefenderCore(OpswatApis apis) {
        this.apis = apis;
        this.rd = new retrieveData(this.apis);
        this.newDataHash = new DataHash(this.apis);
    }


    //
    public void validating(File filePath, String dataId) throws ParseException {
        JSONObject results = null;
        if (!map.containsKey(filePath.getPath())) {
            //upload the file
            uploadFile upload = new uploadFile(apis);
            try {
                //jsonobject = upload.upload(filePath);
                //dataId = (String) jsonobject.get("data_id");
                dataId = "cDE4MDQyMUgxRngxbXhadTN6U3k1eHlRZVpkMmY";
                String hash = rd.retrieve(dataId);
                map.put(filePath.getPath(), hash);
                String retrivehash=map.get(filePath.getPath());
                results = newDataHash.retrieveHash(retrivehash);
                ScanReport report = new ScanReport(results);
                report.display();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            try {
                String hash = map.get(filePath.getPath());
                results = newDataHash.retrieveHash(hash);
                ScanReport report = new ScanReport(results);
                report.display();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

