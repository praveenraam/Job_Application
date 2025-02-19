package com.praveenraam.reviewMicro.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService service;

    @GetMapping
    public ResponseEntity<List<Review>> getAllReviewsofCompany(@RequestParam Long companyId){
        return new ResponseEntity<>(service.findAll(companyId), HttpStatus.OK);
    }
    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewById(@PathVariable Long reviewId){
        Review review = service.findById(reviewId);

        if(review != null) return new ResponseEntity<>(review,HttpStatus.OK);
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createReview(@RequestParam Long companyId, @RequestBody Review review){
        return new ResponseEntity<>(service.createReview(companyId,review),HttpStatus.CREATED);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<Boolean> updateReviewById(@PathVariable Long reviewId,@RequestBody Review review){
        if(service.UpdateById(reviewId,review))
            return new ResponseEntity<>(true,HttpStatus.OK);
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<Boolean> deleteReviewById(@PathVariable Long reviewId){
        if(service.deleteById(reviewId)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_ACCEPTABLE);
    }
}