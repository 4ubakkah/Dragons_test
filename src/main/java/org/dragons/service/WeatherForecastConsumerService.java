package org.dragons.service;

import org.dragons.core.response.GetWeatherResponse;

public interface WeatherForecastConsumerService {

    /**
     * @param id addressed game id
     * @return GetWeatherResponse
     */
    GetWeatherResponse getWeather(long id);

}
