package com.example.weatherdemo2.controller;

import com.example.weatherdemo2.mapper.ForecastMapper;
import com.example.weatherdemo2.mapper.YesterdayMapper;
import com.example.weatherdemo2.pojo.Forecast;
import com.example.weatherdemo2.pojo.Yesterday;
import com.example.weatherdemo2.service.WeatherDataService;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Author: ChenWeiTao
 * Date: 19/07/01
 */

@RestController
@RequestMapping(value ="/data")
public class WeatherDataCotroller {

    @Autowired
    WeatherDataService weatherDataService ;


    @GetMapping("/searchYesterday")
    public Yesterday searchAndSetDataByCityName(String cityName) throws IOException {
        Yesterday yesterday = weatherDataService.getYesterdayByCityName(cityName);
        //读取配置文件
        InputStream in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取sqlsessionfactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //获取session对象
        SqlSession sqlSession = factory.openSession();
        //获取mapper代理对象
        YesterdayMapper usermapper = sqlSession.getMapper(YesterdayMapper.class);
        List<Yesterday> yesterdayCount = usermapper.findYesterdayByCityName(cityName);
        int flag = 0;
        //如果有昨日数据，则更新
        if(yesterdayCount.size()>0){
            try{
                flag = usermapper.updateYesterdayByCityName(yesterday);
                if(flag==1){
                    sqlSession.commit();
                }
                else{
                    sqlSession.rollback();
                }
            }catch(Exception e) {
                e.printStackTrace();
            }
        }
        //否则插入
        else{
            try{
                flag = usermapper.addYesterdayByCityName(yesterday);
                if(flag==1){
                    sqlSession.commit();
                }
                else{
                    sqlSession.rollback();
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return yesterday;
    }

    @GetMapping("/searchForecast")
    public List<Forecast> searchAndSetDatabyCityName(String cityName) throws IOException {
        List<Forecast> forecasts=weatherDataService.getForecastByCityName(cityName);
        //读取配置文件
        InputStream in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取sqlsessionfactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //获取session对象
        SqlSession sqlSession = factory.openSession();
        //获取mapper代理对象
        ForecastMapper usermapper = sqlSession.getMapper(ForecastMapper.class);
        for(Forecast forecast :forecasts){

        }
        return forecasts;
    }
}
