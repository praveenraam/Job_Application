package com.praveenraam.companyMicro.Company;

import com.Praveen.Job_App.Job.Job;
import com.Praveen.Job_App.Review.Review;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Job> jobsOpened;

    @JsonIgnore
    @OneToMany(mappedBy = "company")
    private List<Review> reviewsPosted;


    public Company() {
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }

    public List<Job> getJobsOpened() {
        return jobsOpened;
    }
    public void setJobsOpened(List<Job> jobsOpened) {
        this.jobsOpened = jobsOpened;
    }

    public List<Review> getReviewsPosted() {
        return reviewsPosted;
    }

    public void setReviewsPosted(List<Review> reviewsPosted) {
        this.reviewsPosted = reviewsPosted;
    }
}
