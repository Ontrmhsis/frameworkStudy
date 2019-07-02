package com.example.weatherdemo2.mapper;

import com.example.weatherdemo2.pojo.Yesterday;

import java.util.List;

public interface YesterdayMapper {

    List<Yesterday> findAll();

    List<Yesterday> findYesterdayByCityName(String cityName);

    int addYesterdayByCityName(Yesterday yesterday);

    int updateYesterdayByCityName(Yesterday yesterday);

    int deleteYesterdayByCityName(String cityName);

}
