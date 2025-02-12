package com.Praveen.Job_App.Company;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService service;

    @GetMapping
    public ResponseEntity<List<Company>> getAllCompany(){
        return new ResponseEntity<>(service.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Company> getCompanyById(@PathVariable Long id){
        Company company = service.findById(id);
        if(company == null) return new ResponseEntity<>(company,HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(company,HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> createCompany(@RequestBody Company company){
        return new ResponseEntity<>(service.createCompany(company),HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateCompanyById(@PathVariable Long id,@RequestBody Company company){
        if(service.updateById(id,company)){
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
        return new ResponseEntity<>(false,HttpStatus.NOT_FOUND);
    }
}
