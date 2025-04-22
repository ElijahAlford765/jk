package com.example.jk.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository  extends JpaRepository<Review, Integer> {
    List<Review> findByProviderId(int providerId);
    List<Review> findByReported(boolean reported);
}