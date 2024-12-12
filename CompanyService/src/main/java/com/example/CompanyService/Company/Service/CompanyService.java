package com.example.CompanyService.Company.Service;


import com.example.CompanyService.Company.Dto.ReviewMessagingDto;
import com.example.CompanyService.Company.Entity.Company;
import com.example.CompanyService.Company.Repository.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {

    CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompany() {

        return companyRepository.findAll();
    }

    public Company getCompanyByID(int id) {
        return companyRepository.findById(id).orElse(null);
    }


    public boolean updateCompany(int id, Company company) {
        Optional<Company> res = companyRepository.findById(id);
        if (res.isPresent()) {
            Company companyres = res.get();
            companyres.setDescription(company.getDescription());
            companyres.setDescription(company.getDescription());
            companyres.setName(company.getName());

            companyRepository.save(companyres);
            return true;

        }
        return false;

    }

    public boolean createCompany(Company company) {
        companyRepository.save(company);
        return true;
    }

    public boolean deleteCompany(int cid) {
        if (companyRepository.existsById(cid)) {
            companyRepository.deleteById(cid);
            return true;
        }
        return false;
    }

    public void updateCompanyRating(ReviewMessagingDto reviewMessagingDto) {
        System.out.println(reviewMessagingDto.getDescription());


    }
}
