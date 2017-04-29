package com.example.jpa.service;

import com.example.jpa.domain.City;
import com.example.jpa.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017-04-29.
 */
@Service
public class CityService {

    @Autowired CityRepository cityRepository;

    public City addCity(City city) {
        return cityRepository.save(city);
    }

    public City fetchCity(long id) {
        return cityRepository.findOne(id);
    }

    public long getTotalCount() {
        return cityRepository.count();
    }

}
