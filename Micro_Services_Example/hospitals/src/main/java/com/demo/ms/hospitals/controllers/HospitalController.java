package com.demo.ms.hospitals.controllers;

import com.demo.ms.hospitals.model.Hospital;
import com.demo.ms.hospitals.services.HospitalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
@RestController
@RequestMapping("/hospitals")
public class HospitalController {
    private HospitalService hospitalsService;
    @Autowired
    public void setHospitalsService(HospitalService hospitalsService) {
        this.hospitalsService = hospitalsService;
    }

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody Hospital hospital, UriComponentsBuilder builder){

        //        Article article = new Article();
//        BeanUtils.copyProperties(articleInfo, article);

            hospitalsService.saveOrUpdate(hospital);
//        if (flag == false) {
//            return new ResponseEntity<Void>(HttpStatus.CONFLICT);
//        }

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(builder.path("/patients/{id}").buildAndExpand(hospital.getId()).toUri());
        return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
    }

    @GetMapping("/list")
    public List<Hospital> listPatients(Model model){
        return hospitalsService.listAll();
    }

    @GetMapping("/{id}")
    public Hospital getPatient(@PathVariable String id, Model model){
        return hospitalsService.getById(Long.valueOf(id));
    }

    @PutMapping("/{id}")
    public Hospital edit( @RequestBody Hospital hospital){

        Hospital hospital1 = hospitalsService.getById(hospital.getId());
        Hospital hospital2;

        if(hospital.getId() == hospital1.getId()){
            hospital2 = hospitalsService.saveOrUpdate(hospital);
        }
        return hospital1;
    }

    @RequestMapping("/patient/delete/{id}")
    public String delete(@PathVariable String id){
        hospitalsService.delete(Long.valueOf(id));
        return "true" ;
    }
}
