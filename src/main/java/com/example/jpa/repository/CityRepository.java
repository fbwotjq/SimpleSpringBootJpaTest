package com.example.jpa.repository;

import com.example.jpa.domain.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2017-04-29.
 */
public interface CityRepository extends CrudRepository<City, Long> {

    public Page<City> findAll(Pageable pageable);

    public Page<City> findByNameContainingAndCountryContainingAllIgnoringCase(String name, String country, Pageable pageable);

    public City findByNameAndCountryAllIgnoringCase(String name, String country);

    public int countByCountry(String country);

    public City findByNameAndCountry(String sungnam, String korea);

}
