package com.example.weather.dto.openweathermap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseOpenWeatherMapDto {
    private CoordDto coord;
    private List<WeatherDto> weather;
    private String base;
    private MainDto main;
    private Integer visibility;
    private WindDto wind;
    private CloudsDto clouds;
    private Integer dt;
    private SysDto sys;
    private Integer timezone;
    private Integer id;
    private String name;
    private Integer cod;
}
