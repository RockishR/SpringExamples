package com.demo.ms.management.controller;

import com.demo.ms.management.model.Hospital;
import com.demo.ms.management.model.Patient;
import com.demo.ms.management.model.PatientInfo;

import com.demo.ms.management.service.HospitalRemoteService;
import com.demo.ms.management.service.PatientRemoteService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/management")
public class HealthManagementResource {

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private PatientRemoteService patientRemoteService;

	@Autowired
	private HospitalRemoteService hospitalRemoteService;

	@RequestMapping("/patient/{id}")
	public PatientInfo getPatient(@PathVariable("id") String id) {

		Patient patient = patientRemoteService.getPatient(id);

		Hospital hospital = hospitalRemoteService.getHospital(patient.getHospitalId());

		PatientInfo patientInfo = new PatientInfo();
		patientInfo.addPatient(patient);
		patientInfo.addHospital(hospital);

		return patientInfo;

	}

}
