package com.demo.ms.hospitals.repositories;

import com.demo.ms.hospitals.model.Hospital;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 1/10/17.
 */
public interface HospitalRepository extends CrudRepository<Hospital, Long> {
}
