package com.bigdata1421.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bigdata1421.ssmp.dao.UserDao;
import com.bigdata1421.ssmp.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.xml.ws.soap.Addressing;

@SpringBootTest
public class UserserviceTestCase {

    @Autowired
    private UserService userService;

    @Test
    void testGetById(){
        System.out.println(userService.getById(1));
    }

    @Test
    void testSave(){
        User user=new User();
        user.setId(1);
        user.setName("王连扬");
        user.setAge("21");
        user.setGender("男");
        userService.save(user);
    }

    @Test
    void testUpdate(){
        User user=new User();
        user.setId(11);
        user.setName("王连扬");
        user.setAge("21");
        user.setGender("男");
        userService.update(user);
    }

    @Test
    void testDelete(){
        userService.delete(11);
    }

    @Test
    void testGetAll(){
        userService.geTAll();
    }

    @Test
    void testGetPage(){
        IPage<User>page=userService.getPage(2,5);
        System.out.println(page.getCurrent());
        System.out.println(page.getSize());
        System.out.println(page.getTotal());
        System.out.println(page.getPages());
        System.out.println(page.getRecords());
    }


}
