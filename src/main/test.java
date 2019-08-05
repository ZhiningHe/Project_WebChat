package main;

import com.alibaba.druid.util.JdbcUtils;
import main.com.company.Utils.CommUtil;
import org.junit.Assert;
import org.junit.Test;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServlet;
import java.sql.*;


public class test {
    @Test
    public void test() throws SQLException {
        try {
            //1.加载MySQL驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取数据库连接
            Connection connection = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/jdbc",
                            "root","123456");
            //3.执行SQL语句
            String sql = "select * from user";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println("id为："+resultSet.getString("id")
                +" 用户名为："+resultSet.getString("username")
                        +" 密码为："+resultSet.getString("password"));
            }

            //4.释放资源（连接）
            connection.close();
            statement.close();
            resultSet.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testQuery(){
        Connection connection = null;
        PreparedStatement statement =null;
        ResultSet resultSet = null;


        try{
            //获取连接池中的连接
            //connection = JDBCUtil.getConnection();
            //要执行的sql语句
            String sql = "select * from user where id =? and username = ?";
            //封装执行语句
            statement = connection.prepareStatement(sql);
            statement.setInt(1,2);
            statement.setString(2,"ls");
            //获取查询结果，存到resultSet
            resultSet = statement.executeQuery();
            //输出到控制台
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String userName = resultSet.getString("username");
                String password = resultSet.getString("password");
                System.out.println("id为："+id+" 用户名为："+userName
                        +" 密码为："+password);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //关闭连接
        JDBCUtil.closeRsc(connection,statement,resultSet);


    }




}
