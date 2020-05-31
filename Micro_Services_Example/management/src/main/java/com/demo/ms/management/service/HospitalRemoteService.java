package com.demo.ms.management.service;

import com.demo.ms.management.model.Hospital;
import com.demo.ms.management.model.Patient;
import com.demo.ms.management.model.PatientInfo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class HospitalRemoteService {
    @Autowired
    private RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod ="getFallBackData" )
    public Hospital getHospital(int hospitalId) {
        return restTemplate.getForObject("http://hospital-service/hospitals/"+hospitalId, Hospital.class);
    }

    public Hospital getFallBackData(int id) {
        Hospital hospital = new Hospital();
        hospital.setCity("Fallback City");
        hospital.setName("Fallback Name");

        return hospital;
    }

}

