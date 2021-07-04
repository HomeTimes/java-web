package com.sevice.impl;

import com.dao.UserDao;
import com.dao.daoImpl.UserDaoImpl;
import com.domain.pageUserBean;
import com.domain.user;
import com.sevice.Userservice;

import java.util.List;
import java.util.Map;

public class UserserviceImpl implements Userservice {
    UserDaoImpl userDao=new UserDaoImpl();
    @Override
    public user Login(user user) {
        com.domain.user loginUser = userDao.Login(user.getUsername(), user.getPassword());
        return loginUser;
    }

    public List<user> findAllUser() {
        return userDao.findAllUser();
    }

    @Override
    public void addUser(user user) {
        userDao.addUser(user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    public user finUserId(String id) {
        return userDao.finUserId(id);
    }

    @Override
    public void updateUser(user user) {
         userDao.updateUser(user.getId(),user.getName(),user.getGender(),user.getAge(),user.getAddress(),user.getQq(),user.getEmail());
    }

    @Override
    public void DeleteUserById(String id) {
        userDao.DeleteUserById(id);
    }

    @Override
    public void deleteSelectedUser(String[] uids) {
        for (String id:uids){
            userDao.DeleteUserById(id);
        }
    }

    @Override
    public pageUserBean findUserPage(String _currentPage, String _rows,Map<String, String[]> parameterMap) {
        pageUserBean  pb=new pageUserBean();
        int currentPage =Integer.parseInt(_currentPage);
        if(currentPage<1){
            currentPage =1;
        }
        int rows =Integer.parseInt(_rows);
//        当前页
        pb.setCurrentPage(currentPage);
//        设置每页的记录数
        pb.setRow(rows);
//        总记录数
        int totalCount = userDao.findTotalCount(parameterMap);
        pb.setTotalCount(totalCount);
//        有多少页
        int totalPage = totalCount %  rows == 0 ? totalCount/rows :(totalCount/rows)+1;
        pb.setTotalPage(totalPage);
//        每页的有多少个用户信息
        int limit=(currentPage-1)* rows;
        List<user> curentPageUser = userDao.findCurentPageUser(limit, rows,parameterMap);
        pb.setList(curentPageUser);
        return pb;
    }

}
