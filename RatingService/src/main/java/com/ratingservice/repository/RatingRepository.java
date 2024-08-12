package com.ratingservice.repository;

import com.ratingservice.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RatingRepository extends JpaRepository<Rating, String> {
    List<Rating> findByUserId(String id);
    List<Rating> findByHotelId(String id);
}