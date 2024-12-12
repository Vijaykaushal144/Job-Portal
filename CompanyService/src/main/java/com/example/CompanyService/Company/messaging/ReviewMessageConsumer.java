package com.example.CompanyService.Company.messaging;

import com.example.CompanyService.Company.Dto.ReviewMessagingDto;
import com.example.CompanyService.Company.Service.CompanyService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;

public class ReviewMessageConsumer {
    @Autowired
    private  CompanyService companyService;

    @RabbitListener(queues = "companyRatingQueue")
    public void ConsumeMessage(ReviewMessagingDto reviewMessagingDto)
    {
        companyService.updateCompanyRating(reviewMessagingDto);
    }
}
