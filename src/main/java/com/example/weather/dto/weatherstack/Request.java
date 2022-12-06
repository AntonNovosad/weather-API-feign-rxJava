package com.example.weather.dto.weatherstack;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Request {
    private String city;
    private String query;
    private String language;
    private String unit;
}
