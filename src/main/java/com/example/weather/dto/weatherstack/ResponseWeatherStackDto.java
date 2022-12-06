package com.example.weather.dto.weatherstack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseWeatherStackDto {
    private Request request;
    private Location location;
    private Current current;
}
