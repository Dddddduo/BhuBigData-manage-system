package com.bigdata1421.ssmp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bigdata1421.ssmp.domain.User;
import com.bigdata1421.ssmp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//注释掉后就不会加载为bean了
//@RestController
@RequestMapping("/users")
public class UserController2 {
    //注入业务层
    //@Autowired
    private UserService userService;

    //规定请求方式
    @GetMapping
    public List<User> getAll(){
        return userService.geTAll();
    }

    @PostMapping
    public Boolean save(@RequestBody User user){
        return userService.save(user);
    }

    @PutMapping
    public Boolean update(@RequestBody User user){
        return userService.update(user);
    }

    @DeleteMapping("{id}")
    public Boolean delete(@PathVariable Integer id){
        return userService.delete(id);
    }

    @GetMapping("{id}")
    public  User getById(@PathVariable Integer id){
        return userService.getById(id);
    }

    @GetMapping("{currentPage}/{pageSize}")
    public IPage<User> getPage(@PathVariable int currentPage ,@PathVariable int pageSize){
        return userService.getPage(currentPage,pageSize);
    }

}