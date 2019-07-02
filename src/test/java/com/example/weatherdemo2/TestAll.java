package com.example.weatherdemo2;

import com.example.weatherdemo2.mapper.YesterdayMapper;
import com.example.weatherdemo2.pojo.WeatherResponse;
import com.example.weatherdemo2.pojo.Yesterday;
import com.example.weatherdemo2.service.WeatherDataService;
import com.example.weatherdemo2.service.WeatherDataServiceImpl;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.io.InputStream;

/**
 * Author: ChenWeiTao
 * Date: 19/07/01
 */
public class TestAll {

    @Autowired
    WeatherDataService weatherDataService;
    @Test
    public void TestAll() throws IOException {


        //读取配置文件
        InputStream in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取sqlsessionfactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //获取session对象
        SqlSession sqlSession = factory.openSession();
        //获取mapper代理对象
        YesterdayMapper usermapper = sqlSession.getMapper(YesterdayMapper.class);


    }
}
