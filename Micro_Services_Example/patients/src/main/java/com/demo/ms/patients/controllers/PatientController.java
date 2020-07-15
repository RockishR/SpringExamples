package com.demo.ms.patients.controllers;

import com.demo.ms.patients.model.Patient;
import com.demo.ms.patients.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import springfox.documentation.annotations.Cacheable;

import java.util.List;

@Component
@RestController
@RequestMapping("/patients")
public class PatientController {
    private PatientService patientService;
    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }


    @PostMapping
    public ResponseEntity<Void> create(@RequestBody Patient patient, UriComponentsBuilder builder){

            patientService.saveOrUpdate(patient);
        //        if (flag == false) {
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/patients/{id}").buildAndExpand(patient.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<Patient> listPatients(Model model){
        return patientService.listAll();
    }

    @GetMapping("/{id}")
    public Patient getPatient(@PathVariable String id, Model model){

        try {
            if("2".equals(id)) {
                Thread.sleep(5000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return getCacheByID(id);
    }

    @Cacheable(value = "patients")
    private Patient getCacheByID(String id){
        System.out.println("#### no cache -- calling service method. ");
        return patientService.getById(Long.valueOf(id));
    }


    @PutMapping("/{id}")
    public Patient edit( @RequestBody Patient patient){

        Patient patient1 = patientService.getById(patient.getId());
        Patient patient2;

        if(patient.getId() == patient1.getId()){
            patient2 = patientService.saveOrUpdate(patient);
        }
        return patient1;
    }

    @RequestMapping("/patient/delete/{id}")
    public String delete(@PathVariable String id){
        patientService.delete(Long.valueOf(id));
        return "true" ;
    }

}
