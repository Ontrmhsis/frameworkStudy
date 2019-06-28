package com.example.weatherdemo2.mapper;

import com.example.weatherdemo2.pojo.Forecast;

public interface ForecastMapper {

    public Forecast findAll();

    public Forecast findForecastByCityId(String cityId);

    public Forecast findForecastByCityName(String cityName);

    public int addForecastByCityId(String cityId);

    public int addForecastByCityName(String cityName);

    public int updateForecastByCityId(String cityId);

    public int updateForecastByCityName(String cityName);

    public int deleteForecastByCityId(String cityId);

    public int deleteForecastByCityName(String cityName);
}
