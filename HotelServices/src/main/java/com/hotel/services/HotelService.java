package com.hotel.services;

import com.hotel.HotelServicesApplication;
import com.hotel.entity.Hotels;

import java.util.List;

public interface HotelService {
    //create
    Hotels createHotel(Hotels h);

    //getall
    List<Hotels> getAllHotels();

    //getbyid
    Hotels getHotelById(String id);
}
