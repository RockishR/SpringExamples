package com.demo.ms.management.model;

import lombok.Data;

@Data
public class Patient {

    public Patient(){

    }

    private Long id;
    private String firstName;
    private String lastName;
    private String mobileNo;
    private String city;
    private int hospitalId;
    private String status;

}
