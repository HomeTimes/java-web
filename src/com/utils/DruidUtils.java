package com.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DruidUtils {
//    定义成员变量
    private  static DataSource ds;
    static {
        try {
            //    加载配置文件
            Properties ps = new Properties();
            ps.load(DruidUtils.class.getClassLoader().getResourceAsStream("druid.properties"));
                //获取连接池对象
            ds = DruidDataSourceFactory.createDataSource(ps);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//    从连接池中获取连接对象
    public  static Connection getConnecttion() throws SQLException {
        return  ds.getConnection();
    }
//  关闭资源
    public static  void close(ResultSet set,Statement statement, Connection connection){
        if(set!=null){
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement!=null){
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null){
            try {
                set.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
//重载
    public static  void close(Statement statement, Connection connection){
            close(null,statement,connection);
    }
//    获取连接池对象
    public  static  DataSource getDataSource(){
        return   ds;
    }
}

