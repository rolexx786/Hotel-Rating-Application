package com.usermicro.services.impl;

import com.usermicro.entity.Hotel;
import com.usermicro.entity.Ratings;
import com.usermicro.entity.User;
import com.usermicro.exception.ResourceNotFoundException;
import com.usermicro.external.services.HotelServices;
import com.usermicro.repository.UserRepository;
import com.usermicro.services.UserServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    private RestTemplate restTemplate;
@Autowired
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Autowired
    private HotelServices hotelServices;



    @Override
    public User createUser(User user) {

        String string = UUID.randomUUID().toString();
        user.setId(string);
        User save = userRepository.save(user);
        return save;
    }

    @Override
    public List<User> getUsers() {
        List<User> all = userRepository.findAll();
        
        return all;
    }

    @Override
    public User getUserById(String id) {

        User user = userRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("User with this id Not found" + id));
        Ratings[] ratingsOfusers = restTemplate.getForObject("http://RATING-SERVICE/rating/user/"+user.getId(), Ratings[].class);
        List<Ratings> ratings = Arrays.stream(ratingsOfusers).toList();

        List<Ratings> rating = ratings.stream().map(r -> {
           // ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + r.getHotelId(), Hotel.class);
            Hotel hotel = hotelServices.getHotel(r.getHotelId());
            r.setHotel(hotel);
            return r;
        }).collect(Collectors.toList());

        user.setRating(rating);

        return user;



    }

    @Override
    public User updateUser(User user, String id) {
        Optional<User> byId = userRepository.findById(id);
        User u = byId.get();
        u.setName(user.getName());
        u.setEmail(user.getEmail());
        u.setAbout(user.getAbout());
        User updated = userRepository.save(u);
        return updated;
    }

        @Override
    public void deleteUser(String id) {
            Optional<User> byId = userRepository.findById(id);
            User user = byId.get();
            userRepository.deleteById(id);

        }
}
