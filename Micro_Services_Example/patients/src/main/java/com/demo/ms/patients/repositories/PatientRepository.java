package com.demo.ms.patients.repositories;

import com.demo.ms.patients.model.Patient;
import org.springframework.data.repository.CrudRepository;

public interface PatientRepository extends CrudRepository<Patient, Long> {

}
