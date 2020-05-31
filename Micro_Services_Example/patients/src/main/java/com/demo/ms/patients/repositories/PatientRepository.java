package com.demo.ms.patients.repositories;

import com.demo.ms.patients.model.Patient;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 1/10/17.
 */
public interface PatientRepository extends CrudRepository<Patient, Long> {
}
