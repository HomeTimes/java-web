package com.test;


import com.dao.daoImpl.UserDaoImpl;
import com.domain.user;
import com.sevice.impl.UserserviceImpl;
import org.junit.Test;

import java.util.List;

public class test {
    @Test
    public void login (){
        UserserviceImpl userservice=new UserserviceImpl();
         user user=new user();
         user.setUsername("user");
         user.setPassword("111");
        com.domain.user loginUser = userservice.Login(user);
        System.out.println(loginUser);
    }
    @Test
    public void findallUser (){
        UserserviceImpl userservice=new UserserviceImpl();
        List<user> allUser = userservice.findAllUser();
        System.out.println(allUser);
    }
    @Test
    public void updateUser (){
        UserserviceImpl userservice=new UserserviceImpl();
        user user=new user();
        user.setId(24);
        user.setGender("男");
        userservice.updateUser(user);
     }
    @Test
    public void findTotalCount (){
        UserDaoImpl userDao=new UserDaoImpl();
//        int totalCount = userDao.findTotalCount();
//        System.out.println(totalCount);
    }
    @Test
    public void curentPageUser (){
        UserDaoImpl userDao=new UserDaoImpl();
//        List<user> curentPageUser = userDao.findCurentPageUser(0, 5);
//
//        System.out.println(curentPageUser);
    }
}
