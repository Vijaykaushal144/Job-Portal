package com.example.CompanyService.Company.Dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReviewMessagingDto {

    Integer id;
    String title;
    String description;
    double rating;
    private long companyId;
}
