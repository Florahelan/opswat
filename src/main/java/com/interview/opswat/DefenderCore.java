package com.interview.opswat;

import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

//Main class
public class DefenderCore {

    public static void main(String... args) throws IOException, ParseException {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.metadefender.com/")
                .addConverterFactory(ScalarsConverterFactory.create())
                .build();
        OpswatApiClient opswatApiClient = retrofit.create(OpswatApiClient.class);

        FileProcessor processor = new FileProcessor(opswatApiClient);
        String quit = "quit";
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the filename or Please type 'quit' to exit ");
            String fileName = scanner.nextLine();
            File scanFile = new File("src/main/resources/" + fileName);
            if (quit.equalsIgnoreCase(fileName)) {
                System.out.println("Bye");
                break;
            }
            try {
                ScanReport report = processor.generateResults(scanFile);
                report.display();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
