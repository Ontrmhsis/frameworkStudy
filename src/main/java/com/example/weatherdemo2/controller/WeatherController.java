package com.example.weatherdemo2.controller;

import com.example.weatherdemo2.Service.WeatherDataService;
import com.example.weatherdemo2.pojo.WeatherResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public WeatherResponse getWeatherByCityName(String cityName ){

        return weatherDataService.getDataByCityName(cityName);
    }
}