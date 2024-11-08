package com.bigdata1421.ssmp.domain;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;
import org.springframework.context.annotation.Configuration;

// lombok开发 用注解封装实体类

@Data
@NoArgsConstructor
@Configuration
@Getter
@TableName("tbl_user")
public class User {
    // 定义属性
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String name;
    private String age;
    private String gender;
}
