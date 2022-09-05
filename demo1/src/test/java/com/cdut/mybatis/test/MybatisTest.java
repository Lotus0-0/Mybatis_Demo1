package com.cdut.mybatis.test;

import com.cdut.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

    @Test
    public void testMybatis() throws IOException {
        //加载核心配置文件
        InputStream is = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(is);
        //获取SqlSession
        SqlSession sqlSession=sqlSessionFactory.openSession(true);//自动提交事务

        //获取mapper接口对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);//代理模式

        //测试insertUser()
        int result=userMapper.insertUser();
        //提交事务
        //sqlSession.commit();//可自动提交事务

        //打印结果
        System.out.println("result:"+result);
    }
}
