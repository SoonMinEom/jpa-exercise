package com.exercise.jpa.controller;

import com.exercise.jpa.domain.dto.HospitalResponse;
import com.exercise.jpa.domain.dto.ReviewRequest;
import com.exercise.jpa.service.HospitalService;
import com.exercise.jpa.service.ReviewService;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/hospitals")
public class HospitalController {

    private final HospitalService hospitalService;
    private final ReviewService reviewService;

    public HospitalController(HospitalService hospitalService, ReviewService reviewService) {
        this.hospitalService = hospitalService;
        this.reviewService = reviewService;
    }

    @GetMapping("")
    public ResponseEntity<List<HospitalResponse>> getHospitals(Pageable pageable) {
        return ResponseEntity.ok().body(hospitalService.getHospitals(pageable));
    }

    @PostMapping("/reviews")
    public ResponseEntity<ReviewRequest> saveReview(@RequestBody ReviewRequest reviewRequest) {
        return ResponseEntity.ok().body(reviewService.add(reviewRequest));
    }
}
