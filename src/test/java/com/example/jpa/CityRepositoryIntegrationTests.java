package com.example.jpa;

import com.example.jpa.domain.City;
import com.example.jpa.repository.CityRepository;
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
public class CityRepositoryIntegrationTests {

    @Autowired CityRepository cityRepository;

    @Test
    public void insertAndSelectOne() {

        City willInsertedCity1 = new City();
        willInsertedCity1.setCountry("KOREA");
        willInsertedCity1.setMap("???");
        willInsertedCity1.setName("SEOUL");
        willInsertedCity1.setState("SEOUL");
        cityRepository.save(willInsertedCity1);

        City willInsertedCity2 = new City();
        willInsertedCity2.setCountry("KOREA");
        willInsertedCity2.setMap("???");
        willInsertedCity2.setName("SUNGNAM");
        willInsertedCity2.setState("GUNGGI");
        cityRepository.save(willInsertedCity2);

        int count = cityRepository.countByCountry("KOREA");
        assertThat(count, is(2));

        City selectedCity = cityRepository.findByNameAndCountry("SUNGNAM", "KOREA");
        assertThat(willInsertedCity2.getState(), is(willInsertedCity2.getState()));

    }

}
