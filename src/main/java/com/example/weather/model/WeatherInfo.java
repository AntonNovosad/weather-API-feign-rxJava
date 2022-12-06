package com.example.weather.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class WeatherInfo {
    private String nameApi;
    private String city;
    private String country;
    private Integer temperature;
}
