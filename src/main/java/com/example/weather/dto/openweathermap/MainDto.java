package com.example.weather.dto.openweathermap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MainDto {
    private Integer temp;
    private Integer feels_like;
    private Integer temp_min;
    private Integer temp_max;
    private Integer pressure;
    private Integer humidity;
}
