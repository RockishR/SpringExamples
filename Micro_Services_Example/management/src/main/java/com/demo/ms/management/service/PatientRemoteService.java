package com.demo.ms.management.service;

import com.demo.ms.management.model.Patient;
import com.demo.ms.management.model.PatientInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class PatientRemoteService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod ="getFallBackData" )
    public Patient getPatient(String id) {
        return restTemplate.getForObject("http://patient-service/patients/"+id, Patient.class);
    }

    public Patient getFallBackData(String id) {
        Patient patient = new Patient();
        patient.setCity("Fallback City");
        patient.setFirstName("Fallback Name");
        patient.setHospitalId(1);

        return patient;
    }
}

