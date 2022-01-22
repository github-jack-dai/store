package com.cy.store.mapper;

import com.cy.store.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.Date;

//@RunWith(SpringRunner.class)表示启动这个单元测试类（单元测试类是不能够运行的），需要传递一个参数，必须是SpringRunner的实例类型

@SpringBootTest//表示标注当前的类是一个测试类，不会随同项目一并打包发走
@RunWith(SpringRunner.class)
public class UserMapperTests {
    @Resource
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("tim");
        user.setPassword("123456");
        Integer rows = userMapper.insert(user);
        System.out.println("rows=" + rows);
    }

    @Test
    public void findByUsername() {
        String username = "tim";
        User result = userMapper.findByUsername(username);
        System.out.println(result);
    }

    @Test
    public void updatePasswordByUid() {
        Integer uid = 1;
        String password = "654321";
        String modifiedUser = "普通管理员";
        Date modifiedTime = new Date();
        Integer rows = userMapper.updatePasswordByUid(uid, password, modifiedUser, modifiedTime);
        System.out.println("rows=" + rows);
    }

    @Test
    public void findByUid() {
        Integer uid = 1;
        User result = userMapper.findByUid(uid);
        System.out.println(result);
    }
}

