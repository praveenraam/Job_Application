package com.praveenraam.companyMicro.Company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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


    public boolean deleteById(Long id) {

        if(!repo.existsById(id)) return false;

        try{
            repo.deleteById(id);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
