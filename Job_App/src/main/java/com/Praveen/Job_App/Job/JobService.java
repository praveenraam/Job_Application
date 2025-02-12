package com.Praveen.Job_App.Job;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    @Autowired
    JobRepository repo;

    public List<Job> findAll(){
        return repo.findAll();
    }

    public String createJob(Job job){
        repo.save(job);
        return "Added successfully";
    }

    public Job findById(Long id) {
        return repo.findById(id).orElse(null);
    }

    public boolean deleteById(Long id) {
        try{
            repo.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }

    public boolean updateById(Long id, Job job) {

        Job jobPresent = this.findById(id);

        if(jobPresent == null) return false;

        jobPresent.setTitle(job.getTitle());
        jobPresent.setDescription(job.getDescription());
        jobPresent.setLocation(job.getLocation());
        jobPresent.setMaxSalary(job.getMaxSalary());
        jobPresent.setMinSalary(job.getMinSalary());

        repo.save(jobPresent);
        return true;
    }
}

