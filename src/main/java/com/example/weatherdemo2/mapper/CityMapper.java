package com.example.weatherdemo2.mapper;

import com.example.weatherdemo2.pojo.City;

public interface CityMapper {
    public City findCityIdByCityName(String cityName);

    public City findCityNamebyCityId(String cityId);
}
