package com.demo.ms.hospitals.services;

import com.demo.ms.hospitals.model.Hospital;
import com.demo.ms.hospitals.repositories.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
@Service
public class HospitalServiceImpl implements HospitalService {

    private HospitalRepository hospitalRepository;

    @Autowired
    public HospitalServiceImpl(HospitalRepository hospitalRepository) {
        this.hospitalRepository = hospitalRepository;
    }

    @Override
    public List<Hospital> listAll() {
        List<Hospital> hospitals = new ArrayList<>();
        hospitalRepository.findAll().forEach(hospitals::add); //fun with Java 8
        return hospitals;
    }

    @Override
    public Hospital getById(Long id) {
        return hospitalRepository.findById(id).orElse(null);
    }

    @Override
    public Hospital saveOrUpdate(Hospital hospital) {
        hospitalRepository.save(hospital);
        return hospital;
    }

    @Override
    public void delete(Long id) {
        hospitalRepository.deleteById(id);
    }

}
