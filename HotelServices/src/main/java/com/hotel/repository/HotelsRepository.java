package com.hotel.repository;

import com.hotel.entity.Hotels;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelsRepository extends JpaRepository<Hotels, String> {
}