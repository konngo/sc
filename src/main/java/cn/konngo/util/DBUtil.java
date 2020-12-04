package cn.konngo.util;

import cn.konngo.exception.DBTransforException;

import java.sql.*;
import java.util.List;

// 数据库工具类
public class DBUtil<E> {
    static  String URL="jdbc:mysql://cdb-57vtjqrv.gz.tencentcdb.com:10094/demo120401?useUnicode=true&amp;characterEncoding=utf-8";
    static String USER="demo120401";
    static String PASSWORD="123456";

    // 获取数据库连接
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        return  DriverManager.getConnection(URL, USER, PASSWORD);
    }

    /**
     * 查询数据库
     *
     */
    public List<E> select(String sql, TransforUtil<E> trans,Class<E> clazz) throws SQLException, ClassNotFoundException {
        Connection connection=this.getConnection();
        Statement statement=null;
        ResultSet rs=null;
        try {
            statement=connection.createStatement();
            rs=statement.executeQuery(sql);
            return trans.transfor(rs,clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.close(connection, statement, rs);
        }
        return null;
    }


    /**
     * 查询数据库
     *
     */
    public List<E> select(String sql,TransforUtil<E> trans,Class<E> clazz,Object...values) throws SQLException, ClassNotFoundException {
        Connection connection=this.getConnection();
        PreparedStatement ps=null;
        ResultSet rs=null;
        try {
            ps=connection.prepareStatement(sql);
            for(int i=1;i<=values.length;i++) {
                ps.setObject(i, values[i-1]);
            }
            rs=ps.executeQuery();
            return trans.transfor(rs,clazz);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.close(connection,ps, rs);
        }
        return null;
    }

    // 执行sql语句
    public boolean excute(String sql) throws SQLException, ClassNotFoundException {
        boolean flag=false;
        Connection connection=this.getConnection();
        Statement statement=null;
        ResultSet rs=null;
        try {
            statement=connection.createStatement();
            flag=statement.execute(sql);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            this.close(connection, statement, rs);
        }
        return flag;
    }


    /**
     * 释放资源
     */
    private void close(Connection connection, Statement statement, ResultSet rs) {
        if(rs!=null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(statement!=null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(connection!=null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
