package com.example.ReviewService.Review.Repository;


import com.example.ReviewService.Review.Entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository  extends JpaRepository<Review,Integer> {
    List<Review> findBycompanyId(int cid);
}
