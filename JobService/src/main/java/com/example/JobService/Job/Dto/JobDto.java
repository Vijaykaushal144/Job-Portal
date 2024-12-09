package com.example.JobService.Job.Dto;

import com.example.JobService.Job.External.Company;
import com.example.JobService.Job.External.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class JobDto {
    int jid;
    String title;
    String description;
    int minSalary;
    int maxSalary;
    String location;
    private Company company;
    private List<Review> review;



}
