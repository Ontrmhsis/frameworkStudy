package com.example.weatherdemo2;

import com.example.weatherdemo2.mapper.CityMapper;
import com.example.weatherdemo2.pojo.City;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestCity {

    @Test
    public void testFindAll() throws IOException {


        //读取配置文件
        InputStream in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取sqlsessionfactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //获取session对象
        SqlSession sqlSession = factory.openSession();
        //获取mapper代理对象
        CityMapper usermapper =sqlSession.getMapper(CityMapper.class);
        //执行findAll
        List<City> citys=usermapper.findAll();
        List<City> citys2=usermapper.findCityIdByCityName("长沙");
        List<City> citys3=usermapper.findCityNamebyCityId("101250101");
        for(City city:citys){
            System.out.println(city);
        }
        for(City city:citys2){
            System.out.println(city);
        }
        for(City city:citys3){
            System.out.println(city);
        }
        sqlSession.close();
        in.close();
    }
}
