package com.bigdata1421.ssmp.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bigdata1421.ssmp.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

// Mybatis的数据层注解
@Mapper
public interface UserDao extends BaseMapper<User>{
    void selectPage(IPage page);
    //Mybatis-plus
    //mp快速开发方案

//    @Select("select * from tbl_user where id= #{id}")
//    User getById(Integer id);

}
