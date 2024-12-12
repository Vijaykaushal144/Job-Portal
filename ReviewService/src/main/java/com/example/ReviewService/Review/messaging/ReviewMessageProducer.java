package com.example.ReviewService.Review.messaging;

import com.example.ReviewService.Review.Dto.ReviewMessagingDto;
import com.example.ReviewService.Review.Entity.Review;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ReviewMessageProducer {

    @Autowired
    RabbitTemplate rabbitTemplate;

    public void sendMessage(Review review)
    {
        ReviewMessagingDto reviewMessagingDto= new ReviewMessagingDto();
        reviewMessagingDto.setId(review.getId());
        reviewMessagingDto.setDescription(review.getDescription());
        reviewMessagingDto.setRating(review.getRating());
        reviewMessagingDto.setTitle(review.getTitle());
        reviewMessagingDto.setCompanyId(review.getCompanyId());
        rabbitTemplate.convertAndSend("companyRatingQueue",reviewMessagingDto);

    }
}
