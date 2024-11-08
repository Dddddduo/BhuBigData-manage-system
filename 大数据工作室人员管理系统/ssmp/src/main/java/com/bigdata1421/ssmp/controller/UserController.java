package com.bigdata1421.ssmp.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.bigdata1421.ssmp.controller.utils.Result;
import com.bigdata1421.ssmp.domain.User;
import com.bigdata1421.ssmp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.io.IOException;
import java.util.List;

import static net.sf.jsqlparser.util.validation.metadata.NamedObject.user;

@RestController
@RequestMapping("/users")
public class UserController {
    //注入业务层
    @Autowired
    private UserService userService;

    //规定请求方式
    @GetMapping
    public Result getAll(){
        //加载全数据
        return new Result(true , userService.geTAll());
    }

    @PostMapping
    public Result save(@RequestBody User user) throws  IOException{
        if(user.getName().equals("多多")) throw new IOException();
        System.out.println("添加数据:"+user);
        boolean flag = userService.save(user);
        return new Result(flag,flag?"添加成功 ^_^":"添加失败—_—!");
    }

    @PutMapping
    public Result update(@RequestBody User user)throws  IOException{
        if(user.getName().equals("")||user.getAge().equals("")||user.getGender().equals("")) throw new IOException();
        System.out.println("更新数据:"+user);
        return new Result(true,userService.update(user));
    }

    @DeleteMapping("{id}")
    public Result delete(@PathVariable Integer id){
        System.out.println("删除数据:"+id);
        return new Result(true,userService.delete(id));
    }

    @GetMapping("{id}")
    public  Result getById(@PathVariable Integer id){
        System.out.println("查询数据:"+id);
        return new Result(true,userService.getById(id));
    }

    @GetMapping("{currentPage}/{pageSize}")
    public Result getPage(@PathVariable int currentPage ,@PathVariable int pageSize,User user){
        System.out.println("添加数据"+user);
        IPage<User> page=userService.getPage(currentPage,pageSize,user);
        //如果当前页码值大于总页码值 那么重新执行查询操作 使用最大页码值作为大当前页码值
        if(currentPage>page.getPages()){
            page=userService.getPage((int) page.getPages(),pageSize,user);
        }
        System.out.println("分页数据=>"+currentPage+" "+pageSize);
        return new Result(true,page);
    }

}