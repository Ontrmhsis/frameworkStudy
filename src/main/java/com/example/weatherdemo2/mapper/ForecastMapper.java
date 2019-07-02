package com.example.weatherdemo2.mapper;

import com.example.weatherdemo2.pojo.Forecast;

import java.util.List;

public interface ForecastMapper {

    List<Forecast> findAll();

    List<Forecast> findForecastByCityName(String cityName);

    int addForecastByCityName(Forecast forecast);

    int updateForecastByCityName(Forecast forecast);

    int deleteForecastByCityName(String cityName);
}
