package com.bigdata1421.ssmp.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bigdata1421.ssmp.dao.UserDao;
import com.bigdata1421.ssmp.service.IUserService;
import com.bigdata1421.ssmp.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao,User> implements IUserService {

    @Override
    public boolean save(User user) {
        return false;
    }



}
