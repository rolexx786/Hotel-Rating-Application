package com.hotel.controller;

import com.hotel.entity.Hotels;
import com.hotel.services.HotelService;
import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {
    private HotelService hotelService;

    public HotelController(HotelService hotelService) {
        this.hotelService = hotelService;
    }
    //create
    @PostMapping
    public ResponseEntity<Hotels> createHotel(@RequestBody Hotels h){
        Hotels hotel = hotelService.createHotel(h);
        return new ResponseEntity<>(hotel, HttpStatus.CREATED);


    }


    //getsingle

    @GetMapping("/{hid}")
    public ResponseEntity<Hotels> getHotel(@PathVariable String hid){
        Hotels hotelById = hotelService.getHotelById(hid);
        return new ResponseEntity<>(hotelById, HttpStatus.OK);
    }

    //getall
    @GetMapping
    public ResponseEntity<List<Hotels>> getAllHotels(){
        List<Hotels> allHotels = hotelService.getAllHotels();
        return new ResponseEntity<>(allHotels,HttpStatus.OK);
    }
}
