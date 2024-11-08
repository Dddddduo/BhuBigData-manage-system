package com.bigdata1421.ssmp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.bigdata1421.ssmp.dao.UserDao;
import com.bigdata1421.ssmp.domain.User;
import com.bigdata1421.ssmp.service.UserService;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

// 定义成业务层对应的bean
@Service
public class UserServiceImpl2 implements UserService {
    //注入
    @Autowired
    private UserDao userDao;

    @Override
    public boolean save(User user) {
        return userDao.insert(user) > 0;
    }

    @Override
    public Boolean update(User user) {
        return userDao.updateById(user) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return userDao.deleteById(id) > 0;
    }

    @Override
    public User getById(Integer id) {
        return userDao.selectById(id);
    }

    @Override
    public List<User> geTAll() {
        return userDao.selectList(null);
    }

    @Override
    public IPage<User> getPage(int currentPage, int pageSize) {
        IPage page = new Page(currentPage, pageSize);
        return page;
    }

    @Override
    public IPage<User> getPage(int currentPage, int pageSize, User user) {
        LambdaQueryWrapper<User> lqw = new LambdaQueryWrapper<User>();
        IPage page = new Page(currentPage, pageSize);
        //用like条件匹配
        lqw.like(Strings.isNotEmpty(user.getName()), User::getName, user.getName());
        lqw.like(true, User::getAge, user.getAge());
        lqw.like(Strings.isNotEmpty(user.getGender()), User::getGender, user.getGender());
        userDao.selectPage(page, lqw);
        return page;
    }
}


