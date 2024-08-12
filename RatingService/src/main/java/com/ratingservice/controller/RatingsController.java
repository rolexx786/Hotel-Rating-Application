package com.ratingservice.controller;

import com.ratingservice.entity.Rating;
import com.ratingservice.service.RatingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rating")
public class RatingsController {
    private RatingService ratingService;

    public RatingsController(RatingService ratingService) {
        this.ratingService = ratingService;
    }

    //create
    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating r){
        Rating rating = ratingService.createRating(r);
        return new ResponseEntity<>(rating, HttpStatus.CREATED);

    }

    //getSingle

    @GetMapping("/{rid}")
    public ResponseEntity<Rating> getRatingById(@PathVariable String rid){
        Rating ratingById = ratingService.getRatingById(rid);
        return new ResponseEntity<>(ratingById, HttpStatus.OK);

    }
    //getAllRatings
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        List<Rating> aLlRatings = ratingService.getALlRatings();
        return new ResponseEntity<>(aLlRatings,HttpStatus.OK);
    }

    @GetMapping("/user/{uid}")
    public ResponseEntity<List<Rating>> getAllRatingsbyUserid(@PathVariable String uid){
        List<Rating> aLlRatings = ratingService.getRatingByUserId(uid);
        return new ResponseEntity<>(aLlRatings,HttpStatus.OK);
    }

    @GetMapping("/hotel/{hid}")
    public ResponseEntity<List<Rating>> getAllRatingsbyHotelid(@PathVariable String hid){
        List<Rating> aLlRatings = ratingService.getRatingByHotelId(hid);
        return new ResponseEntity<>(aLlRatings,HttpStatus.OK);
    }




}
