package com.ratingservice.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table
@Getter
@Setter
public class Rating {
    @Id
    private String ratingId;

    private String userId;
    private String hotelId;
    private int rating;
    private String feedback;

}
