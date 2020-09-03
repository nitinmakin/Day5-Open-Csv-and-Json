package com.bridgelabz.opencsv.service;
import com.opencsv.CSVReader;
import java.io.*;
import java.nio.file.*;
public class ReadCsvFile {
    private static final String SAMPLE_CSV_FILE_PATH = "D:\\fellowship\\Day5-Open-Csv-and-Json\\" +
                                                       "src\\test\\resources\\csvReader.csv";

    public static void main(String[] args) throws IOException {
        try (
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CSVReader csvReader = new CSVReader(reader);
        ) {
            // Reading Records One by One in a String array
            String[] nextRecord;
            while ((nextRecord = csvReader.readNext()) != null) {
                System.out.println("Name : " + nextRecord[0]);
                System.out.println("Email : " + nextRecord[1]);
                System.out.println("Phone : " + nextRecord[2]);
                System.out.println("Country : " + nextRecord[3]);
                System.out.println("==========================");
            }
        }
    }
}
