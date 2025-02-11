package com.Praveen.Job_App.Job;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {
    private List<Job> jobs = new ArrayList<>();
    private static Long nextID = 1L;
    public ResponseEntity<List<Job>> findAll(){
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }

    public ResponseEntity<String> createJob(Job job){
        job.setId(nextID);
        nextID+=1;
        jobs.add(job);
        return new ResponseEntity<>("Added successfully",HttpStatus.CREATED);
    }

    public ResponseEntity<Job> findById(Long id) {

        for(Job job : jobs)
            if(job.getId() == id)
                return new ResponseEntity<>(job,HttpStatus.OK);

        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    public boolean deleteById(Long id) {

        for(Job job : jobs)
            if(job.getId() == id){
                jobs.remove(job);
                return true;
            }
        return false;
    }

    public boolean updateById(Long id, Job job) {

        for(Job jobIter : jobs)
            if(jobIter.getId() == id){
                jobIter.setDescription(job.getDescription());
                jobIter.setLocation(job.getLocation());
                jobIter.setTitle(job.getTitle());
                jobIter.setMaxSalary(job.getMaxSalary());
                jobIter.setMinSalary(job.getMinSalary());

                return true;
            }

        return false;
    }
}

