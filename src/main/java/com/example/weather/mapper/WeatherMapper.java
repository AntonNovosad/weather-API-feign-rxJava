package com.example.weather.mapper;

import com.example.weather.dto.openweathermap.ResponseOpenWeatherMapDto;
import com.example.weather.dto.weatherstack.ResponseWeatherStackDto;
import com.example.weather.model.WeatherInfo;
import org.springframework.stereotype.Component;

@Component
public class WeatherMapper {
    public WeatherInfo convertToWeatherInfo(ResponseWeatherStackDto responseWeatherDto) {
        return WeatherInfo.builder()
                .nameApi("weatherstack.com")
                .city(responseWeatherDto.getLocation().getName())
                .country(responseWeatherDto.getLocation().getCountry())
                .temperature(responseWeatherDto.getCurrent().getTemperature())
                .build();
    }

    public WeatherInfo convertToWeatherInfo(ResponseOpenWeatherMapDto responseWeatherDto) {
        return WeatherInfo.builder()
                .nameApi("openweathermap.org")
                .city(responseWeatherDto.getName())
                .country(responseWeatherDto.getSys().getCountry())
                .temperature(responseWeatherDto.getMain().getTemp())
                .build();
    }
}
