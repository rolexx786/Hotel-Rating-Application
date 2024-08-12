package com.ratingservice.service;

import com.ratingservice.entity.Rating;

import java.util.List;

public interface RatingService {
    //create_Ratings
    Rating createRating(Rating r);

    //get_single_raiting

    Rating getRatingById(String id);

    //Get_ALl_Ratings

    List<Rating> getALlRatings();

    List<Rating> getRatingByUserId(String id);

    List<Rating> getRatingByHotelId(String id);


}
