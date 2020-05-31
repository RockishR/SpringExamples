package com.demo.ms.management.model;

import lombok.Data;

@Data
public class PatientInfo {

    public void addPatient(Patient patient){
        id = patient.getId();
        firstName = patient.getFirstName();
        lastName = patient.getLastName();
        mobileNo = patient.getMobileNo();
        city = patient.getCity();
    }

    public void addHospital(Hospital hospital){
        hospitalId = hospital.getId();
        hospitalCity = hospital.getCity();
        hospitalContactNo = hospital.getContactNo();
        hospitalName = hospital.getName();
    }

    private Long id;
    private String firstName;
    private String lastName;
    private String mobileNo;
    private String city;
    private Long hospitalId;
    private String status;
//Hospital info
    private String hospitalName;
    private String hospitalContactNo;
    private String hospitalCity;

}
