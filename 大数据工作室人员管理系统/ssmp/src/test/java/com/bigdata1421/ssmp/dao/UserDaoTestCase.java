package com.bigdata1421.ssmp.dao;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bigdata1421.ssmp.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.management.Query;

@SpringBootTest
public class UserDaoTestCase {

    @Autowired
    private UserDao userDao;

    //根据ID查询
    @Test
    void testGetById(){
        System.out.println(userDao.selectById(1));
    }

    //增
    @Test
    void testSave(){
        User user=new User();
        user.setId(10);
        user.setName("李懿航");
        user.setAge("20");
        user.setGender("男");
        userDao.insert(user);
    }

    //改
    @Test
    void testUpdate(){
        User user=new User();
        user.setId(10);
        user.setName("李懿航");
        user.setAge("20");
        user.setGender("男");
        userDao.updateById(user);
    }

    //删
    @Test
    void testDelete(){
        userDao.deleteById(10);
    }

    //查询所有数据
    @Test
    void testGetAll(){
        System.out.println( userDao.selectList(null));
    }

    //分页查询
    @Test
    void testGetPage(){
        IPage page=new Page(1,3);
        //这是那一页的数据 每一页显示多少数据
        userDao.selectPage(page,null);
    }

    //按条件查询
    @Test
    void testGetBy1(){
        // select * from tbl_ where name like %高%
        //容器
        QueryWrapper<User> qw1=new QueryWrapper<>();
        //条件
        qw1.like("name","高");
        //查询
        userDao.selectList(qw1);
    }
}
