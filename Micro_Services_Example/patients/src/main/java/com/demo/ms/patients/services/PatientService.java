package com.demo.ms.patients.services;

import com.demo.ms.patients.model.Patient;

import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
public interface PatientService {

    List<Patient> listAll();

    Patient getById(Long id);

    Patient saveOrUpdate(Patient patient);

    void delete(Long id);

}
