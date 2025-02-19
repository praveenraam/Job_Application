package com.praveenraam.reviewMicro.Review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReviewService {

    @Autowired
    ReviewRepository repo;

    public List<Review> findAll(Long companyId){
        return repo.findByCompanyId(companyId);
    }

    public String createReview(Long companyId, Review review) {
        if(companyId == null) return "Company not exists";

        review.setCompanyId(companyId);
        repo.save(review);

        return "Review Added Successfully";
    }

    public Review findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public boolean UpdateById(Long id,Review review){

        Review updatingReview = this.findById(id);
        if(updatingReview == null) return false;

        updatingReview.setDescription(review.getDescription());
        updatingReview.setRating(review.getRating());
        updatingReview.setTitle(review.getTitle());
        updatingReview.setCompanyId(review.getCompanyId());

        repo.save(updatingReview);
        return true;
    }

    public boolean deleteById(Long Id){
        if(!repo.existsById(Id)) return false;

        try{
            repo.deleteById(Id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }


}