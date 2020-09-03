package com.bridgelabz.opencsv.service;
import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
public class ReadAllDataAtOnce {
    public static void main(String[] args)  {
        try {
            FileReader filereader = new FileReader("D:\\fellowship\\Day5-Open-Csv-and-Json" +
                    "\\src\\test\\resources\\csvReader.csv");
            CSVReader csvReader = new CSVReader(filereader);

            // Reading all  Records at Once
            List<String[]> allData = csvReader.readAll();

            for (String[] record : allData) {
                System.out.println("Name : " + record[0]);
                System.out.println("Email : " + record[1]);
                System.out.println("Phone : " + record[2]);
                System.out.println("Country : " + record[3]);
                System.out.println("==========================");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}