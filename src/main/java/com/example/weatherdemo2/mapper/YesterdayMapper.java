package com.example.weatherdemo2.mapper;

import com.example.weatherdemo2.pojo.Yesterday;

public interface YesterdayMapper {
    public Yesterday findYesterdayByCityId(String cityId);

    public Yesterday findYesterdayByCityName(String cityName);

    public int addYesterdayByCityId(String cityId);

    public int addYesterdayByCityName(String cityName);

    public int updateYesterdayByCityId(String cityId);

    public int updateYesterdayByCityName(String cityName);

    public int deleteYesterdayByCityId(String cityId);

    public int deleteYesterdayByCityName(String cityName);

}
