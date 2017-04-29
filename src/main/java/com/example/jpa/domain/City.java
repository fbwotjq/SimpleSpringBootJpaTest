package com.example.jpa.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * Created by Administrator on 2017-04-29.
 */
@Entity @Data
public class City {

    @Id @GeneratedValue private Long id;
    @Column(nullable = false) private String name;
    @Column(nullable = false) private String state;
    @Column(nullable = false) private String country;
    @Column(nullable = false) private String map;

    @Override
    public String toString() {
        return String.format("[ID::%s, NAME:%s:, STATE::%s, COUNTRY::%s, MAP::%s]");
    }

}
