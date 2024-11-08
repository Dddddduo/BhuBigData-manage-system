package com.bigdata1421.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bigdata1421.ssmp.domain.User;

public interface IUserService extends IService<User> {
    // 继承注解 如果报错了就代表是新方法
    // 如果没报错就把重写注解留着
    @Override
    boolean save(User user);



}
