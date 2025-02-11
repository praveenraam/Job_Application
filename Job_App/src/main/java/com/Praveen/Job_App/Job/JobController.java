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
    public ResponseEntity<List<Job>> findAll(){
        return service.findAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Job> findById(@PathVariable Long id){
        return service.findById(id);
    }

    @PostMapping
    public ResponseEntity<String> createJob(@RequestBody Job job){
        return service.createJob(job);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateById(@PathVariable Long id,@RequestBody Job job){
        if(service.updateById(id,job)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteById(@PathVariable Long id){
        if(service.deleteById(id)){
            return new ResponseEntity<>(true, HttpStatus.OK);
        };
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }

}
