package com.hotel.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "hotels")
public class Hotels {
    @Id
    @Column(name = "id", nullable = false, length = 255)
    private String id;

    @Column(name = "name", nullable = false, length = 50)
    private String name;

    @Column(name = "location", nullable = false, length = 50)
    private String location;

    @Column(name = "about", nullable = false)
    private String about;

}