package com.example.weatherdemo2;

import com.example.weatherdemo2.mapper.CityMapper;
import com.example.weatherdemo2.pojo.City;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Weatherdemo2ApplicationTests {

    @Test
    public void testFindAll() throws IOException {
        //读取配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        //获取sqlsessionfactory
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
        //获取session对象
        SqlSession sqlSession = factory.openSession();
        //获取mapper代理对象
        CityMapper usermapper = sqlSession.getMapper(CityMapper.class);
        //执行findAll
        List<City> citys = usermapper.findAll();
        for (City city : citys) {
            System.out.println(city);
        }
    }

}
