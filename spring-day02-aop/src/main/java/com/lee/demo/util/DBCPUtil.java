package com.lee.demo.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;

import javax.sql.DataSource;


public class DBCPUtil {

    private static DataSource ds = null;

    static {// 静态代码块类中方法外
        try {
            Properties p = new Properties();
            // 加载注册资源
            p.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("dbcp.properties"));
            ds = null;// BasicDataSourceFactory.createDataSource(p);// 创建连接池对象

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //获取连接池对象
    static public Connection getConn() {
        try {
            // 从连接池获取Connection对象
            return ds.getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    // 关闭资源
    static public void close(Connection conn, Statement st, ResultSet rs) {
        try {
            if (st != null) {
                st.close();
            }
        } catch (Exception e) {
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (Exception e) {
            }
        }
    }

}
