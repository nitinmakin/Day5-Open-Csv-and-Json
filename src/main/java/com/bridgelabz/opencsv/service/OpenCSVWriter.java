package com.bridgelabz.opencsv.service;

import com.bridgelabz.opencsv.module.MyUser;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
public class OpenCSVWriter{
    private static final String Object_List_Sample = "D:\\fellowship\\Day5-Open-Csv-and-Json\\src\\test\\resources\\csvwriter";

    public static void main(String[] args) throws IOException,
            CsvDataTypeMismatchException,
            CsvRequiredFieldEmptyException {
        try (
                Writer writer = Files.newBufferedWriter(Paths.get(Object_List_Sample));
        ) {
            StatefulBeanToCsv<MyUser> beanToCsv = new StatefulBeanToCsvBuilder(writer)
                    .withQuotechar(CSVWriter.NO_QUOTE_CHARACTER)
                    .build();

            List<MyUser> myUsers = new ArrayList<>();
            myUsers.add(new MyUser("vicky", "nitinmakin124@gmail.com", "+91-123456789", "india"));
            myUsers.add(new MyUser("niko", "vicky124@gmail.com", "+91-123456789", "india"));

            beanToCsv.write(myUsers);
        }
    }
}