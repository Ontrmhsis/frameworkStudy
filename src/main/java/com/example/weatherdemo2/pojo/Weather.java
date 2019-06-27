package com.example.weatherdemo2.pojo;

import java.util.List;

public class Weather  {
    private String city;
    private Yesterday yesterday;
    //private String aqi;
    private String ganmao;
    private String wendu;
    private List<Forecast> forecast;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Yesterday getYesterday() {
        return yesterday;
    }

    public void setYesterday(Yesterday yesterday) {
        this.yesterday = yesterday;
    }

//    public String getAqi() {
//        return aqi;
//    }
//
//    public void setAqi(String aqi) {
//        this.aqi = aqi;
//    }

    public String getGanmao() {
        return ganmao;
    }

    public void setGanmao(String ganmao) {
        this.ganmao = ganmao;
    }

    public String getWendu() {
        return wendu;
    }

    public void setWendu(String wendu) {
        this.wendu = wendu;
    }

    public List<Forecast> getForecast() {
        return forecast;
    }

    public void setForecast(List<Forecast> forecast) {
        this.forecast = forecast;
    }


}
