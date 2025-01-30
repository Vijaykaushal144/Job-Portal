package com.example.CompanyService.Company.Controller;


import com.example.CompanyService.Company.Entity.Company;
import com.example.CompanyService.Company.Service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;

    @GetMapping("/getAllCompany")
    public List<Company> getAll() {
        return companyService.getAllCompany();
    }

    @GetMapping("/getCompanyByID/{id}")
    public ResponseEntity<Company> getCompanyID(@PathVariable int id)
    {
        Company company= companyService.getCompanyByID(id);
        if(company!=null)
        {
            return new ResponseEntity<>(company, HttpStatus.OK);

        }
        return  new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping("/updateCompany/{cid}")
    public ResponseEntity<String> updateCompany(@PathVariable int cid, @RequestBody Company company) {
        boolean res = companyService.updateCompany(cid, company);
        if (res) {
            return new ResponseEntity<>("Company Updated Succesfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Not Update", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/createCompany")
    public ResponseEntity<String> createCompany(@RequestBody Company company) {
        boolean cresult = companyService.createCompany(company);
        if (cresult) {
            return new ResponseEntity<>("Company Created SuccessFully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Job Not Created", HttpStatus.BAD_REQUEST);

    }

    @DeleteMapping("/deleteCompany/{cid}")
    public ResponseEntity<String> deleteCompany(@PathVariable int cid) {
        boolean res = companyService.deleteCompany(cid);
        if (res) {
            return new ResponseEntity<>("Company Deleted Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Not Deleted", HttpStatus.NOT_FOUND);
    }
}
