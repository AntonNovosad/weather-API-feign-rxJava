package com.example.weather.service;

import com.example.weather.dto.RequestWeatherDto;
import com.example.weather.dto.openweathermap.ResponseOpenWeatherMapDto;
import com.example.weather.dto.weatherstack.ResponseWeatherStackDto;
import com.example.weather.mapper.WeatherMapper;
import com.example.weather.model.WeatherInfo;
import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import lombok.RequiredArgsConstructor;
import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class WeatherService {
    private static final String WEATHER_STACK_URL = "http://api.weatherstack.com/current?access_key=";
    private static final String OPEN_WEATHER_URL = "https://api.openweathermap.org/data/2.5/weather?q=";
    private final HttpClient httpClient = HttpClientBuilder.create().build();
    private final ClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory(httpClient);
    private final RestTemplate restTemplate = new RestTemplate(requestFactory);
    private final WeatherMapper weatherMapper;
    @Value("${weathestack}")
    private String weatherstackKey;
    @Value("${openweather}")
    private String openweatherKey;

    public List<WeatherInfo> getWeather(RequestWeatherDto requestWeatherDto) {
        String city = requestWeatherDto.getQuery();
        String weatherStackUrl = WEATHER_STACK_URL + weatherstackKey + "&query=" + city;
        String openWeatherUrl = OPEN_WEATHER_URL + city + "&units=metric&appid=" + openweatherKey;
        List<WeatherInfo> list = new ArrayList<>();
        try {
            Observable.just(restTemplate)
                    .subscribeOn(Schedulers.computation())
                    .map(restTemplate -> restTemplate.getForObject(new URI(weatherStackUrl), ResponseWeatherStackDto.class))
                    .map(weatherMapper::convertToWeatherInfo)
                    .blockingSubscribe(list::add);
            Observable.just(restTemplate)
                    .subscribeOn(Schedulers.computation())
                    .map(restTemplate -> restTemplate.getForObject(new URI(openWeatherUrl), ResponseOpenWeatherMapDto.class))
                    .map(weatherMapper::convertToWeatherInfo)
                    .blockingSubscribe(list::add);
            return list;
        } catch (Exception e) {
            throw new RuntimeException();
        }
    }
}

