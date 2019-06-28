package com.example.weatherdemo2.Service;


import com.example.weatherdemo2.pojo.WeatherResponse;

public interface WeatherDataService {

    WeatherResponse getDataByCityId(String cityId);

    WeatherResponse getDataByCityName(String cityName);
}
