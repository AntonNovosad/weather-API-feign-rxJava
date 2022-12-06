package com.example.weather.controller;

import com.example.weather.dto.RequestWeatherDto;
import com.example.weather.model.WeatherInfo;
import com.example.weather.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class FeignController {
    private final WeatherService weatherService;

    public FeignController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    @GetMapping("/weather")
    public List<WeatherInfo> getWeather(@RequestBody RequestWeatherDto requestWeatherDto) {
        return weatherService.getWeather(requestWeatherDto);
    }
}
