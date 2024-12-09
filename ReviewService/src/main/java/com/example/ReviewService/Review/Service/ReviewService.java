package com.example.ReviewService.Review.Service;


import com.example.ReviewService.Review.Entity.Review;
import com.example.ReviewService.Review.Repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService {

    @Autowired
    ReviewRepository reviewRepository;


    public List<Review> getAllReview(Integer cid) {
        return reviewRepository.findBycompanyId(cid);

    }


    // method for create review for a company

    public boolean createReview(Integer cid, Review review) {

        //1. find company for corresponding id which is created in company service class.


        //2. check it is present or not


        //3. Map the company in to our Review Entity Class parameter ;
        if (cid != null && review != null) {
            review.setCompanyId(cid);
            reviewRepository.save(review);


            return true;
        }

        return false;

    }

    public Review getReviewByID( int reviewId) {
        Review review= reviewRepository.findById(reviewId).orElse(null);

        return review;

    }


    public boolean updateReviewByID(Integer reviewId, Review review) {

        Review review1 = reviewRepository.findById(reviewId).orElse(null);
        review1.setCompanyId(review.getCompanyId());
        review1.setDescription(review.getDescription());
        review1.setTitle(review.getTitle());
        review1.setRating(review.getRating());
        reviewRepository.save(review1);
        return true;

    }


    public boolean deleteReviewByID(Integer reviewId) {

        //four step
        //1. check company and review by id
        //2. get review from company and update the company then remove the review
        Review review = reviewRepository.findById(reviewId).orElse(null);

        if (review != null) {
            reviewRepository.deleteById(reviewId);

            return true;

        }
        return false;
    }
}
