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

}
