package com.bigdata1421.ssmp.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bigdata1421.ssmp.domain.User;

import java.util.List;

public interface UserService {
    boolean save(User user);
    Boolean update(User user);
    Boolean delete(Integer id);
    User getById(Integer id);
    List<User> geTAll();

    //分页查询
    IPage<User> getPage(int currentPage , int pageSize);
    IPage<User> getPage(int currentPage , int pageSize ,User user);

}
