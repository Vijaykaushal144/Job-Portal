package com.example.CompanyService.Company.Service;


import com.example.CompanyService.Company.Dto.ReviewMessagingDto;
import com.example.CompanyService.Company.Entity.Company;
import com.example.CompanyService.Company.Exception.InvalidInputException;
import com.example.CompanyService.Company.Exception.ResourceNotFound;
import com.example.CompanyService.Company.Repository.CompanyRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompany() {

       List<Company>ls=  companyRepository.findAll();
       if(ls.isEmpty())
       {
           throw new ResourceNotFound("There Is No Company");
       }
       return ls;

    }

    public Company getCompanyByID(int id) {

        Company company= companyRepository.findById(id).orElseThrow(()->new ResourceNotFound("No Company is Available : " + id));
       // return companyRepository.findById(id).orElse(null);
        return company;
    }


    public boolean updateCompany(int id, Company company) {
        if(company.getName().isBlank() || company.getDescription().isEmpty())
        {
            throw new InvalidInputException("Company name and description can not empty : ");

        }
        Company companyres = companyRepository.findById(id).orElseThrow(()-> new ResourceNotFound("Resource not found for id " + id));
            if (companyres !=null) {
                //Company companyres = res.get();
                companyres.setDescription(company.getDescription());
                companyres.setDescription(company.getDescription());
                companyres.setName(company.getName());
                companyRepository.save(companyres);
                return true;
        }

        return false;

    }

    public boolean createCompany(Company company) {
        if(company.getName() == null && company.getDescription() == null)
        {
            throw new InvalidInputException("Company name and description can not empty");
        }
        return true;
    }

    public boolean deleteCompany(int cid) {
        if (!companyRepository.existsById(cid)) {
            throw new ResourceNotFound("No Company Is present for this Id :" +cid);
        } else {
            companyRepository.deleteById(cid);
            return true;
        }

    }

    public void updateCompanyRating(ReviewMessagingDto reviewMessagingDto) {
        System.out.println(reviewMessagingDto.getDescription());


    }

}
