package com.example.JobService.Job.feinClient;


import com.example.JobService.Job.External.Company;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COMPANY-SERVICE")
public interface CompanyClient {

    @GetMapping("/company/getCompanyByID/{cId}")
    public  Company getCompany(@PathVariable("cId") int cId);
}
