package com.dao.daoImpl;

import com.dao.UserDao;
import com.domain.user;
import com.utils.DruidUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class UserDaoImpl implements UserDao {
    JdbcTemplate template = new JdbcTemplate(DruidUtils.getDataSource());

    @Override
    public int findTotalCount(Map<String, String[]> parameterMap) {

        String sql="select count(*)from user where 1=1";
        Set<String> set = parameterMap.keySet();
        StringBuilder builder=new StringBuilder(sql);
        List<Object> list = new ArrayList<>();
        for (String key:set){
            if("CurrentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            String value = parameterMap.get(key)[0];
            if(value !=null && !"".equals(value)){
                builder.append(" and "+key+" like ? ");
                list.add("%"+value+"%");
            }
        }
        sql=builder.toString();
        System.out.println(builder);
        System.out.println(list);
        return template.queryForObject(sql,Integer.class,list.toArray());
    }

    @Override
    public user Login(String username, String password) {
        try {
            String sql = "select * from user where username=? and password = ?";
            user loginUser = template.queryForObject(sql, new BeanPropertyRowMapper<user>(user.class), username, password);
            return loginUser;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<user> findAllUser() {
        String sql = "select  * from user ";
        List<user> allUser = template.query(sql, new BeanPropertyRowMapper<user>(user.class));
        return allUser;
    }


    @Override
    public void addUser(String name, String gender, int age, String address, String qq, String email) {
        String sql = "insert into user (name,gender,age,address,qq,email)values (?,?,?,?,?,?)";
        template.update(sql, name, gender, age, address, qq, email);
    }

    @Override
    public user finUserId(String id) {
        String sql = "select * from user where id=?";
        user user = template.queryForObject(sql, new BeanPropertyRowMapper<user>(user.class), id);
        return user;
    }

    @Override
    public void updateUser(int id, String name, String gender, int age, String address, String qq, String email) {
        //        update  表名 set  列名1=值1，列名2=值2，，，【where】

        String sql = "update user set name = ?,gender= ?, age= ?, address=?,qq = ?,email=? where id =?";
        template.update(sql, name, gender, age, address, qq, email, id);
    }

    @Override
    public void DeleteUserById(String id) {
        String sql = "delete from  user where id= ?";
        template.update(sql, id);
    }

    @Override
    public List<user> findCurentPageUser(int limit, int rows,Map<String, String[]> parameterMap) {

        String sql="select * from  user where 1=1 ";
        Set<String> set = parameterMap.keySet();
        StringBuilder builder=new StringBuilder(sql);
        List<Object> list = new ArrayList<>();
        for (String key:set){
            if("CurrentPage".equals(key)||"rows".equals(key)){
                continue;
            }
            String value = parameterMap.get(key)[0];
            if(value != null && !"".equals(value)){
                builder.append(" and "+key+" like ? ");
                list.add("%"+value+"%");
            }
        }
        builder.append(" limit ?,?");
        list.add(limit);
        list.add(rows);
        sql=builder.toString();
        System.out.println(builder);
        System.out.println(list);
        List<user> findCurentPageUser = template.query(sql, new BeanPropertyRowMapper<user>(user.class), list.toArray());
        return findCurentPageUser;
    }
}
