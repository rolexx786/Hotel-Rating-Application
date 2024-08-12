package com.usermicro.external.services;

import com.usermicro.entity.Hotel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient("HOTEL-SERVICE")
public interface HotelServices {

    @GetMapping("/hotels/{hid}")
    Hotel getHotel(@PathVariable String hid);
}
