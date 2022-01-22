package com.cy.store.service;

import com.cy.store.entity.User;
import com.cy.store.service.ex.ServiceException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@SpringBootTest
@RunWith(SpringRunner.class)
public class UserServiceTests {
    @Autowired
    private IUserService iUserService;
    @Test
    public void reg(){
        try {
            User user = new User();
            user.setUsername("吴彦祖");
            user.setPassword("123");
            iUserService.reg(user);
            System.out.println("注册成功");
        }catch (ServiceException e){
            System.out.println("注册失败"+e.getClass().getName());
            System.out.println(e.getMessage());
        }
    }
    @Test
    public void login() {
        try {
            String username = "lisa";
            String password = "123";
            User user = iUserService.login(username, password);
            System.out.println("登录成功！" + user);
        } catch (ServiceException e) {
            System.out.println("登录失败！" + e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }

    @Test
    public void changePassword() {
        try {
            Integer uid = 2;
            String username = "lisa";
            String oldPassword = "321";
            String newPassword = "123";
            iUserService.changePassword(uid, username, oldPassword, newPassword);
            System.out.println("密码修改成功！");
        } catch (ServiceException e) {
            System.out.println("密码修改失败！" + e.getClass().getSimpleName());
            System.out.println(e.getMessage());
        }
    }
}
