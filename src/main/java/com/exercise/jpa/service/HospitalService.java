package com.exercise.jpa.service;

import com.exercise.jpa.domain.dto.BookResponse;
import com.exercise.jpa.domain.dto.HospitalResponse;
import com.exercise.jpa.domain.dto.ReviewRequest;
import com.exercise.jpa.domain.entity.Hospital;
import com.exercise.jpa.domain.entity.Review;
import com.exercise.jpa.repository.HospitalRepository;
import com.exercise.jpa.repository.ReviewRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HospitalService {

    private final HospitalRepository hospitalRepository;
    private final ReviewRepository reviewRepository;

    public HospitalService(HospitalRepository hospitalRepository, ReviewRepository reviewRepository) {
        this.hospitalRepository = hospitalRepository;
        this.reviewRepository = reviewRepository;
    }

    public List<HospitalResponse> getHospitals(Pageable pageable) {
        Page<Hospital> hospitals = hospitalRepository.findAll(pageable);
        List<HospitalResponse> hospitalResponses = hospitals.stream()
                .map(hospital -> HospitalResponse.of(hospital)).collect(Collectors.toList());
        return hospitalResponses;
    }

    public HospitalResponse getHospital(int id) {
        Optional<Hospital> optionalHospital = hospitalRepository.findById(id);
        HospitalResponse hospitalResponse=HospitalResponse.of(optionalHospital.get());
        return hospitalResponse;
    }


}
