package com.demo.ms.patients.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String mobileNo;
    private String city;
    private int hospitalId;
    private String status;

    //@OneToMany
    //ArrayList

}
//verify in mock
//new features.
//spring boot test
//rules engine .. emp, list, Apache - Jrules , Drules, jboss
//Closures

