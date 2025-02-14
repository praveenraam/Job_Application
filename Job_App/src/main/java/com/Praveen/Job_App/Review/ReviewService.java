package com.Praveen.Job_App.Review;

import com.Praveen.Job_App.Company.Company;
import com.Praveen.Job_App.Company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class ReviewService {

    @Autowired
    ReviewRepository repo;
    @Autowired
    CompanyService companyService;

    public List<Review> findAll(Long companyId){
        return repo.findByCompanyId(companyId);
    }

    public String createReview(Long companyId, Review review) {
        Company company = companyService.findById(companyId);
        if(company == null) return "Company not exists";

        review.setCompany(company);
        repo.save(review);

        return "Review Added Successfully";
    }

    public Review findById(Long companyId, Long id) {

        List<Review> reviewsOfCompany = this.findAll(companyId);

        return reviewsOfCompany.stream()
                .filter(review -> review.getId().equals(id))
                .findFirst()
                .orElse(null);

    }

}