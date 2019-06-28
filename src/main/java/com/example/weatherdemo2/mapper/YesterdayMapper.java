package com.example.weatherdemo2.mapper;

import com.example.weatherdemo2.pojo.Yesterday;

import java.util.List;

public interface YesterdayMapper {

    List<Yesterday> findAll();

    List<Yesterday> findYesterdayByCityId(String cityId);

    List<Yesterday> findYesterdayByCityName(String cityName);

    int addYesterdayByCityId(String cityId);

    int addYesterdayByCityName(String cityName);

    int updateYesterdayByCityId(String cityId);

    int updateYesterdayByCityName(String cityName);

    int deleteYesterdayByCityId(String cityId);

    int deleteYesterdayByCityName(String cityName);

}
