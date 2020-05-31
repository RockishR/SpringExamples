package com.demo.ms.patients.services;

import com.demo.ms.patients.model.Patient;
import com.demo.ms.patients.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository){
        this.patientRepository = patientRepository;
    }

    @Override
    public List<Patient> listAll() {
        List<Patient> patients = new ArrayList<>();
        patientRepository.findAll().forEach(patients::add); //fun with Java 8
        return patients;
    }

    @Override
    public Patient getById(Long id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient saveOrUpdate(Patient patient) {
        patientRepository.save(patient);
        return patient;
    }

    @Override
    public void delete(Long id) {
        patientRepository.deleteById(id);
    }

}
