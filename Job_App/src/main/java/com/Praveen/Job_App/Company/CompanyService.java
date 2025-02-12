package com.Praveen.Job_App.Company;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {

    @Autowired
    private CompanyRepository repo;

    public List<Company> findAll(){
        return repo.findAll();
    }
    public Company findById(Long id){
        return repo.findById(id).orElse(null);
    }

    public String createCompany(Company company){
        repo.save(company);
        return "Added Successfully";
    }

    public boolean updateById(Long id,Company company){
        Company companyPresent = this.findById(id);

        if(companyPresent == null) return false;

        companyPresent.setName(company.getName());
        companyPresent.setDescription(company.getDescription());
        companyPresent.setJobsOpened(company.getJobsOpened());

        repo.save(companyPresent);
        return true;
    }



}
