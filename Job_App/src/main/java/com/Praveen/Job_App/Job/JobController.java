package com.Praveen.Job_App.Job;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/jobs")
public class JobController {

    @Autowired
    private JobService service;

    @GetMapping
    public ResponseEntity<List<Job>> getAllJobs(){
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<Job> getJobById(@PathVariable Long id){
        Job returnedValue = service.findById(id);

        if(returnedValue != null) return new ResponseEntity<>(returnedValue,HttpStatus.OK);
        return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        return new ResponseEntity<>(service.createJob(job),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateJobById(@PathVariable Long id,@RequestBody Job job){
        if(service.updateById(id,job)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteJobById(@PathVariable Long id){
        if(service.deleteById(id)){
            return new ResponseEntity<>(true, HttpStatus.OK);
        };
        return new ResponseEntity
                <>(false,HttpStatus.NOT_ACCEPTABLE);
    }

}
