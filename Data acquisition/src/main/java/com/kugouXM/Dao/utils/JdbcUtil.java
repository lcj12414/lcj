package com.kugouXM.Dao.utils;
/***
 * 抽取jdbc帮助类
 * */
import java.sql.*;

public class JdbcUtil {
    private static final String Driver_CLASS="com.mysql.jdbc.Driver";
    private  static final String URL="jdbc:mysql://localhost:3306/test?characterEncoding=utf-8";
    private static final  String USER="root";
    private static final String PASSWORD="glxy";

    static {
        try {
            Class.forName(Driver_CLASS);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static Connection createConnection() throws SQLException {
            return DriverManager.getConnection(URL,USER,PASSWORD);
    }
    public static void close(Connection res, PreparedStatement pst, Connection con)throws SQLException{
        if(res!=null)
            res.close();
        if(pst!=null)
            pst.close();
        if(con!=null)
            con.close();
    }

}
