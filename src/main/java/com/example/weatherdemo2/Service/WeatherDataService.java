package com.example.weatherdemo2.service;


import com.example.weatherdemo2.pojo.Forecast;
import com.example.weatherdemo2.pojo.WeatherResponse;
import com.example.weatherdemo2.pojo.Yesterday;

import java.util.List;

public interface WeatherDataService {

    WeatherResponse getDataByCityId(String cityId);

    WeatherResponse getDataByCityName(String cityName);

    List<Forecast> getForecastByCityName(String cityName);

    Yesterday getYesterdayByCityName(String cityName);
}
