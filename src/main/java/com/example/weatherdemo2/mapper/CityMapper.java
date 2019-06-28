package com.example.weatherdemo2.mapper;

import com.example.weatherdemo2.pojo.City;

import java.util.List;

public interface CityMapper {
    List<City> findAll();

    List<City> findCityIdByCityName(String cityName);
//
    List<City> findCityNamebyCityId(String cityId);
}
