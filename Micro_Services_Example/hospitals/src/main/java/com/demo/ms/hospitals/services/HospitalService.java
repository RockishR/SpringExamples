package com.demo.ms.hospitals.services;

import com.demo.ms.hospitals.model.Hospital;

import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
public interface HospitalService {

    List<Hospital> listAll();

    Hospital getById(Long id);

    Hospital saveOrUpdate(Hospital patient);

    void delete(Long id);

}
