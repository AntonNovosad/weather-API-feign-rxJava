package com.example.weather.dto.openweathermap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysDto {
    private Integer type;
    private Integer id;
    private String country;
    private Integer sunrise;
    private Integer sunset;
}
