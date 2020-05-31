package com.demo.ms.management.model;

import lombok.Data;

@Data
public class Hospital {

    public Hospital(){

    }
    private Long id;
    private String Name;
    private String contactNo;
    private String city;

}
