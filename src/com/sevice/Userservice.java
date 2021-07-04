package com.sevice;

import com.domain.pageUserBean;
import com.domain.user;

import java.util.List;
import java.util.Map;

public interface Userservice {
    public user Login(user user);
    public List<user> findAllUser();

    void addUser(user user);

    user finUserId(String id);

    void updateUser(user user);

    void DeleteUserById(String id);

    void deleteSelectedUser(String[] uids);

    pageUserBean findUserPage(String currentPage, String rows, Map<String, String[]> parameterMap);

}
