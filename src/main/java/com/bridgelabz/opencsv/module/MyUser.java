package com.bridgelabz.opencsv.module;

import com.opencsv.bean.CsvBindByName;

public class MyUser {

     String name;
    private String email;
    private String phoneNo;
    private String country;

    public MyUser (String name, String email, String phoneNO, String country)
    {
        this.country=country;
        this.email=email;
        this.name=name;
        this.phoneNo=phoneNO;
    }

}
