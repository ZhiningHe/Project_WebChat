package dao;

import   entity.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;

/**
 * 关于用户的dao层
 * 1.用户的登陆
 * 2.用户的注册
 *
 */
public class BaseDao extends dao.DaoHandle {
    //用户登陆 select
    public User Client_loading(String userName, String password) {
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;
        User user = null;
        try {
            connection = getConnection();
            String sql = "SELECT * FROM user WHERE username =? AND"+" password = ?;";
            statement = connection.prepareStatement(sql);
            statement.setString(1, userName);
            //加密的密码
            statement.setString(2, DigestUtils.md5Hex(password));
            //获取结果(封装到一个user对象中)
            resultSet = statement.executeQuery();
            if (resultSet.next()) {
                user = getClass_User(resultSet);
            }
        } catch (Exception e) {
            System.err.println("用户登陆异常");
            e.printStackTrace();
        } finally {
            closeRsc(connection, statement, resultSet);
        }
        return user;
    }

    //用户注册 insert
    public boolean Client_register(User user) {
        String userName = user.getUserName();
        String password = user.getPassword();
        Connection connection = null;
        PreparedStatement statement = null;
        boolean isSuccess = false;
        try {
            connection = getConnection();
            String sql = "INSERT INTO user(username,password)" + "values(?,?)";
            statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, userName);
            statement.setString(2, DigestUtils.md5Hex(password));
            //检查是否被更新
            isSuccess = (statement.executeUpdate() == 1);
        } catch (SQLException e) {
            System.err.println("用户注册失败");
            e.printStackTrace();
        } finally {
            closeRsc(connection, statement);
        }
        return isSuccess;
    }


    //将数据表信息（resultSet）封装到user类中
    public User getClass_User(ResultSet resultSet) throws SQLException {
        User user = new User();
        user.setId(resultSet.getInt("id"));
        user.setUserName(resultSet.getString("username"));
        user.setPassword(resultSet.getString("password"));
        return user;
    }
}

