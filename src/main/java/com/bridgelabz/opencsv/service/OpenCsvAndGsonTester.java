package com.bridgelabz.opencsv.service;
import com.bridgelabz.opencsv.module.CSVUser;
import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
public class OpenCsvAndGsonTester {
    private static final String SAMPLE_CSV_FILE_PATH = "D:\\fellowship\\Day5-Open-Csv-and-Json\\src\\test\\resources\\csvReader.csv";
        private static final String SAMPLE_JSON_FILE_PATH = "D:\\fellowship\\Day5-Open-Csv-and-Json\\src\\test\\resources\\jsonReader.json";

        public static void main(String[] args)  {
            try {
                Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
                CsvToBeanBuilder<CSVUser> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
                csvToBeanBuilder.withType(CSVUser.class);
                csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
                CsvToBean<CSVUser> csvToBean = csvToBeanBuilder.build();
                List<CSVUser> csvUsers = csvToBean.parse();
                Gson gson = new Gson();
                String json = gson.toJson(csvUsers);
                FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
                writer.write(json);
                writer.close();
                BufferedReader br = new BufferedReader(new FileReader(SAMPLE_JSON_FILE_PATH));
                CSVUser[] usrObj = gson.fromJson(br, CSVUser[].class);
                List<CSVUser> csvUserList = Arrays.asList(usrObj);
                System.out.println(csvUserList.get(0));
                System.out.println(csvUserList.get(1));
                System.out.println(csvUserList.get(2));
                System.out.println(csvUserList.get(3));
                System.out.println(csvUserList.get(4));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

}
