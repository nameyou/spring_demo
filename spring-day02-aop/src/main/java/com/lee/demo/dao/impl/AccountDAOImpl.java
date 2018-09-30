package com.lee.demo.dao.impl;

import com.lee.demo.dao.AccountDAO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.test.context.jdbc.Sql;

import java.sql.*;

@Repository
public class AccountDAOImpl implements AccountDAO {


    @Value("${jdbc.driver}")
    private String driver;
    @Value("${jdbc.url}")
    private String url;
    @Value("${jdbc.username}")
    private String username;
    @Value("${jdbc.password}")
    private String password;

    public void transfer() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet resultSet = null;

        try {
            //注册驱动
            Class.forName(driver);
            //获取连接
            con = DriverManager.getConnection(url, username, password);

            //JDBC中事务是默认提交的
            //设置自动提交事务为false；
            con.setAutoCommit(false);

            //----------------------查询男朋友账户金额是否够用----------------------------------
            String sql = "SELECT * FROM account where name =? AND money > ?";
//            String sql = "SELECT * FROM account where id=? AND name =?";
            //获取预编译对象
            ps = con.prepareStatement(sql);
            //设置参数
            ps.setString(1, "男朋友");
            ps.setInt(2, 0);
            //执行查询
            resultSet = ps.executeQuery();
            //处理结果
            while (!resultSet.next()) {
                throw new RuntimeException("余额不足！！！");
            }

            //------------------男朋友账户金额减少------------------------------
            String sql1 = "update account set money=money - ? where name=?";
            //预编译sql
            ps = con.prepareStatement(sql1);
            //设置参数
            ps.setInt(1, 100);
            ps.setString(2, "男朋友");
            //处理结果
            ps.executeUpdate();
            System.out.println("男人____转账成功。。。。😔");
            //--------------------模拟异常-----------------------------
//            int i = 1 / 0;

            //-------------------女朋友账户金额增加------------------------------
            String sql2 = "update account set money=money+? where name=?";
            ps = con.prepareStatement(sql2);
            ps.setInt(1, 100);
            ps.setString(2, "女朋友");
            ps.executeUpdate();
            System.out.println("女人____收到钱了。。摸摸哒");

            //提交事务
            con.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                //回滚事务
                con.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        } finally {
            try {
                //释放资源
                resultSet.close();
                con.close();
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
