package com.dao;

import com.domain.user;

import java.util.List;
import java.util.Map;

public interface UserDao {
  int   findTotalCount(Map<String, String[]> parameterMap);

  public user Login(String username, String password);

    List<user> findAllUser();

    void addUser(String name, String gender, int age, String address, String qq, String email);

  user finUserId(String id);

  void updateUser(int id,String name, String gender, int age, String address, String qq, String email);

    void DeleteUserById(String id);

  List <user> findCurentPageUser(int limit, int rows,Map<String, String[]> parameterMap);
}
