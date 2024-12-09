package com.example.JobService.Job.Mapper;

import com.example.JobService.Job.External.Company;
import com.example.JobService.Job.Dto.JobDto;
import com.example.JobService.Job.Entity.Job;
import com.example.JobService.Job.External.Review;

import java.util.List;

public class JobMapper {

    public static JobDto mapToJobWithCompanyDto(Job job, Company company, List<Review> review) {

        JobDto jobDto = new JobDto();
        jobDto.setJid(job.getJid());
        jobDto.setTitle(job.getTitle());
        jobDto.setLocation(job.getLocation());
        jobDto.setDescription(job.getDescription());
        jobDto.setMinSalary(job.getMinSalary());
        jobDto.setMaxSalary(job.getMaxSalary());
        jobDto.setCompany(company);

        jobDto.setReview(review);


        return jobDto;

    }
}
