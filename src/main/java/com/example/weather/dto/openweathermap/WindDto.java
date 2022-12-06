package com.example.weather.dto.openweathermap;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WindDto {
    private Integer speed;
    private Integer deg;
    private Integer gust;
}
