package com.hotel.services.impl;

import com.hotel.entity.Hotels;
import com.hotel.repository.HotelsRepository;
import com.hotel.services.HotelService;
import org.springframework.stereotype.Service;
import org.springframework.web.client.ResourceAccessException;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceImpl implements HotelService {

    private HotelsRepository hotelsRepository;

    public HotelServiceImpl(HotelsRepository hotelsRepository) {
        this.hotelsRepository = hotelsRepository;
    }

    @Override
    public Hotels createHotel(Hotels h) {
        String string = UUID.randomUUID().toString();
        h.setId(string);

        Hotels save = hotelsRepository.save(h);
        return save;
    }

    @Override
    public List<Hotels> getAllHotels() {
        List<Hotels> all = hotelsRepository.findAll();
        return all;
    }

    @Override
    public Hotels getHotelById(String id) {
        Hotels hotels = hotelsRepository.findById(id).orElseThrow(() -> new ResourceAccessException("Hotel with this id is not available" + id));
        return hotels;
    }
}
