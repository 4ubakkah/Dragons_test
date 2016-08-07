package org.dragons.service.impl;

import org.dragons.core.response.GetWeatherResponse;
import org.dragons.service.WeatherForecastConsumerService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.*;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class WeatherForecastConsumerServiceITest {

    @Autowired
    private WeatherForecastConsumerService service;

    @Test
    public void shouldGetWeather() throws Exception {
        GetWeatherResponse response = service.getWeather(1);

        assertThat(response).isNotNull();
        assertThat(response.getCode()).isNotNull();
        assertThat(response.getMessage()).isNotNull();
    }
}