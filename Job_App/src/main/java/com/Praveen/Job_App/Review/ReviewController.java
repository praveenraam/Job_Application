package com.Praveen.Job_App.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/companies/{companyId}")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @GetMapping("/reviews")
    public ResponseEntity<List<Review>> getAllReviewsofCompany(@PathVariable Long companyId){
        return new ResponseEntity<>(service.findAll(companyId), HttpStatus.OK);
    }

    @PostMapping("/reviews")
    public ResponseEntity<String> createReview(@PathVariable Long companyId, @RequestBody Review review){
        return new ResponseEntity<>(service.createReview(companyId,review),HttpStatus.CREATED);
    }

    @GetMapping("/reviews/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long companyId,@PathVariable Long reviewId){
        Review review = service.findById(companyId,reviewId);

        if(review != null) return new ResponseEntity<>(review,HttpStatus.OK);
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

}