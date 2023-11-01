package com.upc.cargasinestres.CargaSinEstres.controller;

import com.upc.cargasinestres.CargaSinEstres.model.Review;
import com.upc.cargasinestres.CargaSinEstres.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/reviews/v1")
public class ReviewController {
    @Autowired
    private IReviewService reviewService;

    public ReviewController(IReviewService IReviewService){
        this.reviewService = IReviewService;
    }

    // Method: GET - by CompanyId
    @GetMapping("/reviews/{companyId}")
    public ResponseEntity<List<Review>> getReviewsByCompanyId(@RequestParam(name="companyId") Long companyId){
        return new ResponseEntity<List<Review>>(reviewService.getReviewsByCompanyId(companyId), HttpStatus.OK);
    }

    // Method: POST
    @PostMapping("/reviews")
    public ResponseEntity<Review> createReview(@RequestBody Review review){
        return new ResponseEntity<Review>(reviewService.createReview(review), HttpStatus.CREATED);
    }


}
