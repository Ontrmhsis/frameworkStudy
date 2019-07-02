package com.example.weatherdemo2.controller;

import com.example.weatherdemo2.service.WeatherDataService;
import com.example.weatherdemo2.pojo.Forecast;
import com.example.weatherdemo2.pojo.WeatherResponse;
import com.example.weatherdemo2.pojo.Yesterday;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value ="/weather")
public class WeatherController {

    @Autowired
    private WeatherDataService weatherDataService;

    @GetMapping(value = "/cityId")
    public WeatherResponse getWeatherByCityId(String cityId){
        return weatherDataService.getDataByCityId(cityId);
    }

    @GetMapping(value="/cityName")
    public WeatherResponse getWeatherByCityName(String cityName){
        return weatherDataService.getDataByCityName(cityName);
    }

    @GetMapping(value = "/forecast")
    public List<Forecast> getForecastByCityName(String cityName){
        return weatherDataService.getForecastByCityName(cityName);
    }
    @GetMapping(value = "/yesterday")
    public Yesterday getYesterdayBycityName(String cityName){
        Yesterday yesterday = weatherDataService.getYesterdayByCityName(cityName);

        return yesterday;
    }
}