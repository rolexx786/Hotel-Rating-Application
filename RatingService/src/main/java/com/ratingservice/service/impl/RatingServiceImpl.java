package com.ratingservice.service.impl;

import com.ratingservice.entity.Rating;
import com.ratingservice.repository.RatingRepository;
import com.ratingservice.service.RatingService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {


    private RatingRepository ratingRepository;

    public RatingServiceImpl(RatingRepository ratingRepository) {
        this.ratingRepository = ratingRepository;
    }

    @Override
    public Rating createRating(Rating r) {
        String string = UUID.randomUUID().toString();
        r.setRatingId(string);
        Rating save = ratingRepository.save(r);
        return save;
    }

    @Override
    public Rating getRatingById(String id) {
        Rating rating = ratingRepository.findById(id).orElseThrow(() -> new ResourceAccessException("The rating of this id not found" + "id"));
        return rating;
    }

    @Override
    public List<Rating> getALlRatings() {
        List<Rating> all = ratingRepository.findAll();
        return all;
    }

    @Override
    public List<Rating> getRatingByUserId(String id) {
        List<Rating> byUserId = ratingRepository.findByUserId(id);
        return byUserId;
    }

    @Override
    public List<Rating> getRatingByHotelId(String id) {
        List<Rating> byHotelId = ratingRepository.findByHotelId(id);
        return byHotelId;
    }
}
