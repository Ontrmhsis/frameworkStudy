package com.example.weatherdemo2;

import com.example.weatherdemo2.mapper.ForecastMapper;
import com.example.weatherdemo2.mapper.YesterdayMapper;
import com.example.weatherdemo2.pojo.Forecast;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestForecast {

    public static void main(String[] args) throws IOException {
        //读取配置文件
        InputStream in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取sqlsessionfactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //获取session对象
        SqlSession sqlSession = factory.openSession();
        //获取mapper代理对象
        ForecastMapper usermapper =sqlSession.getMapper(ForecastMapper.class);
        List<Forecast> forecastList = usermapper.findAll();
        for(Forecast forecast : forecastList ){
            System.out.println(forecast);
        }
    }

}
