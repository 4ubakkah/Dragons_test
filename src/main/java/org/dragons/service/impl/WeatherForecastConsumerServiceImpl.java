package org.dragons.service.impl;

import org.dragons.core.response.GetWeatherResponse;
import org.dragons.core.utils.ConnectionConfiguration;
import org.dragons.service.WeatherForecastConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherForecastConsumerServiceImpl implements WeatherForecastConsumerService {

    @Autowired
    private ConnectionConfiguration connectionConfiguration;

    @Override
    public GetWeatherResponse getWeather(long gameId) {
        RestTemplate restTemplate = new RestTemplate();

        GetWeatherResponse response = restTemplate.getForObject(connectionConfiguration.getWeatherUrl(), GetWeatherResponse.class, gameId);

        return response;
    }
}