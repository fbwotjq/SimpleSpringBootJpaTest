package com.example.jpa;

import com.example.jpa.domain.City;
import com.example.jpa.repository.CityRepository;
import com.example.jpa.service.CityService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Created by Administrator on 2017-04-29.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@TestPropertySource(properties = "spring.jpa.hibernate.use-new-id-generator-mappings=false")
public class CityServiceIntegrationTests {

    @Autowired CityService cityService;
    @Autowired CityRepository cityRepository;

    @After
    public void cleanCityAfter() {
        cityRepository.deleteAll();
    }

    @Before
    public void cleanCityBefore() {
        cityRepository.deleteAll();
    }

    @Test
    public void AddAndFetchOne() {

        City willInsertedCity1 = new City();
        willInsertedCity1.setCountry("KOREA");
        willInsertedCity1.setMap("???");
        willInsertedCity1.setName("SEOUL");
        willInsertedCity1.setState("SEOUL");
        City insertedCitry = cityService.addCity(willInsertedCity1);

        City willInsertedCity2 = new City();
        willInsertedCity2.setCountry("KOREA");
        willInsertedCity2.setMap("???");
        willInsertedCity2.setName("SUNGNAM");
        willInsertedCity2.setState("GUNGGI");
        cityService.addCity(willInsertedCity2);

        long count = cityService.getTotalCount();
        assertThat(count, is(2L));

        City city = cityService.fetchCity(insertedCitry.getId());
        assertThat(willInsertedCity1.getName(), is(city.getName()));

    }

}
