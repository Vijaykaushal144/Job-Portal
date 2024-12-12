package com.example.ReviewService.Review.Controller;


import com.example.ReviewService.Review.Entity.Review;
import com.example.ReviewService.Review.Service.ReviewService;
import com.example.ReviewService.Review.messaging.ReviewMessageProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    ReviewService reviewService;

    @Autowired
    ReviewMessageProducer reviewMessageProducer;

    @GetMapping
    public ResponseEntity<List<Review>> getReview(@RequestParam int cId) {
        List<Review> allReview = reviewService.getAllReview(cId);
//       return new ResponseEntity<>(allReview, HttpStatus.OK);

        if (!allReview.isEmpty()) {
            return new ResponseEntity<>(allReview, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }

    @PostMapping
    public ResponseEntity<String> createReview(@RequestParam int cId, @RequestBody Review review) {
        boolean res = reviewService.createReview(cId, review);
        if (res) {

            //it for sending message to company service.
         //   reviewMessageProducer.sendMessage(review);

            return new ResponseEntity<>("Created Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Note Created ", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReviewByID( @PathVariable int reviewId) {
        Review review = reviewService.getReviewByID( reviewId);
        if (review != null) {
            return new ResponseEntity<>(review, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable int reviewId, @RequestBody Review review) {
        if (reviewService.updateReviewByID(reviewId, review)) {
            return new ResponseEntity<>("Review Updated Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review Not updated", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable int reviewId)
    {
        if (reviewService.deleteReviewByID(reviewId)) {
            return new ResponseEntity<>("Review Updated Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review Not updated", HttpStatus.NOT_FOUND);

    }
}
