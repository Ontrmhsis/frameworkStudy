package com.example.weatherdemo2.service;

import com.example.weatherdemo2.pojo.Forecast;
import com.example.weatherdemo2.pojo.WeatherResponse;
import com.example.weatherdemo2.pojo.Yesterday;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class WeatherDataServiceImpl implements WeatherDataService {

    private static final String WEATHER_URI = "http://wthrcdn.etouch.cn/weather_mini?";
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public WeatherResponse getDataByCityId(String cityId) {
        String uri = WEATHER_URI + "citykey=" + cityId;
        return this.getWeatherResponse(uri);
    }

    @Override
    public WeatherResponse getDataByCityName(String cityName) {
        String uri = WEATHER_URI + "city=" + cityName;
        return this.getWeatherResponse(uri);
    }

    private WeatherResponse getWeatherResponse(String uri) {
        ResponseEntity<String> respString = restTemplate.getForEntity(uri, String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        WeatherResponse resp = null;
        String strBody = null;
        if (respString.getStatusCodeValue() == 200) {
            strBody = respString.getBody();
        }
        try {
            resp = objectMapper.readValue(strBody, WeatherResponse.class);
        } catch (Exception e)
        {
            e.printStackTrace();
        }
        return resp;
    }

    @Override
    public List<Forecast> getForecastByCityName(String cityName) {

        WeatherResponse weatherResponse = getDataByCityName(cityName);
        List<Forecast> forecast = weatherResponse.getData().getForecast();
        for(Forecast fore:forecast){
            fore.setCityName(cityName);
        }
        return forecast;
    }

    @Override
    public Yesterday getYesterdayByCityName(String cityName) {
        WeatherResponse weatherResponse = getDataByCityName(cityName);
        Yesterday yesterday = weatherResponse.getData().getYesterday();
        yesterday.setCityName(cityName);
        return yesterday;
    }
}