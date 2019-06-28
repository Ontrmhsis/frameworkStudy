package com.example.weatherdemo2;

import com.example.weatherdemo2.mapper.CityMapper;
import com.example.weatherdemo2.mapper.YesterdayMapper;
import com.example.weatherdemo2.pojo.City;
import com.example.weatherdemo2.pojo.Yesterday;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestYesterday{

    @Test
    public void testFindAll() throws IOException {
        //读取配置文件
        InputStream in= Resources.getResourceAsStream("SqlMapConfig.xml");
        //获取sqlsessionfactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //获取session对象
        SqlSession sqlSession = factory.openSession();
        //获取mapper代理对象
        YesterdayMapper usermapper =sqlSession.getMapper(YesterdayMapper.class);
        //执行findAll
        List<Yesterday> yesterdays=usermapper.findYesterdayByCityId("101250101");
        for(Yesterday yesterday:yesterdays){
            System.out.println(yesterday);
        }
    }
}
