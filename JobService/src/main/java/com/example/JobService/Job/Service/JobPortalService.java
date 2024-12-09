package com.example.JobService.Job.Service;


import com.example.JobService.Job.External.Company;
import com.example.JobService.Job.Dto.JobDto;
import com.example.JobService.Job.Entity.Job;
import com.example.JobService.Job.External.Review;
import com.example.JobService.Job.Mapper.JobMapper;
import com.example.JobService.Job.Repository.JobPortalRepository;
import com.example.JobService.Job.feinClient.CompanyClient;
import com.example.JobService.Job.feinClient.ReviewClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class JobPortalService {

    @Autowired
    JobPortalRepository jobPortalRepository;

    @Autowired
    RestTemplate restTemplate;

    @Autowired
     CompanyClient companyClient;
    @Autowired
    ReviewClient reviewClient;


    public List<JobDto> getAllJob() {
        List<Job> jobs = jobPortalRepository.findAll();
        List<JobDto> jobDtos = new ArrayList<>();

        for (Job job : jobs) {

            // Retrieve company info and handle null responses
        //            Company company = restTemplate.getForObject(
        //
            //     "http://COMPANY-SERVICE:8081/company/getCompanyByID/" + job.getCompanyId(), Company.class);



//            ResponseEntity<List<Review>> reviewResponse = restTemplate.exchange("http://REVIEW-SERVICE:8083/reviews?cId=" + job.getCompanyId(),
//                    HttpMethod.GET,
//                    null,
//                    new ParameterizedTypeReference<List<Review>>() {
//                    });





            //inter-service communication using feign client
            //using feign client

            Company company = companyClient.getCompany(job.getCompanyId());

            List<Review> reviews= reviewClient.getReviews(job.getCompanyId());

            JobDto jobDto = JobMapper.mapToJobWithCompanyDto(job, company,reviews);
            jobDtos.add(jobDto);

        }
        return jobDtos;

    }

    public boolean createJob(Job job) {
        ///job.setJid(id++);
        jobPortalRepository.save(job);
        return true;

    }

    public JobDto getjobById(int id) {

        Job job = jobPortalRepository.findById(id).orElse(null);


        // Retrieve company info and handle null responses using rest template
//        Company company = restTemplate.getForObject(
//                "http://COMPANY-SERVICE:8081/company/getCompanyByID/" + job.getCompanyId(), Company.class);
//
//        ResponseEntity<List<Review>> reviewResponse = restTemplate.exchange("http://REVIEW-SERVICE:8083/reviews?cId=" + job.getCompanyId(),
//                HttpMethod.GET,
//                null,
//                new ParameterizedTypeReference<List<Review>>() {
//                });




        //inter-service communication using feign client
        //using feign client

        Company company = companyClient.getCompany(job.getCompanyId());

        List<Review> reviews= reviewClient.getReviews(job.getCompanyId());




        JobDto jobDto = JobMapper.mapToJobWithCompanyDto(job, company,reviews);
        //jobWithCompanyDto.setCompany(company);


        return jobDto;


    }


    public boolean deleteById(int id) {
        try {
            jobPortalRepository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;

        }

    }


    public boolean updateByID(int id, Job job) {


        Optional<Job> jb = jobPortalRepository.findById(id);
        if (jb.isPresent()) {
            Job jb1 = jb.get();
            jb1.setDescription(job.getDescription());
            jb1.setLocation(job.getLocation());
            jb1.setTitle(job.getTitle());
            jb1.setMinSalary(job.getMinSalary());
            jb1.setMaxSalary(job.getMaxSalary());
            jb1.setLocation(job.getLocation());

            return true;
        }

        return false;
    }


}
