import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.Scanner;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

public class Main {
    public static final String API_URL = "https://api.metadefender.com/";

    public static void main(String... args) throws IOException, ParseException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(API_URL)
                .addConverterFactory(ScalarsConverterFactory.create())

                .build();
        OpswatApis opswat = retrofit.create(OpswatApis.class);

        retrieveData retrieve= new retrieveData(opswat);
        MetadefenderCore core= new MetadefenderCore(opswat);
        String quit = "quit";
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the filename path or quit to exit ");
            String userinput = scanner.nextLine();
            if (quit.equalsIgnoreCase(userinput)) {
                System.out.println("Bye");
                break;
            }
           core.validating(userinput, null);
        }
    }
}
