package company.Chat.dao;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;
import company.Chat.Utils.CommUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


/**
 * 完成模板方法
 * 1.初始化配置
 * 2.获取连接和释放连接
 */
public class DaoHandle {
    private static DruidDataSource dataSource;

    //静态代码块，加载配置文件，只加载一次
    static {
        Properties properties = CommUtil.
                loadProperties("datasource.properties");
        try {
            //加载数据源，注册驱动
            dataSource = (DruidDataSource) DruidDataSourceFactory
                    .createDataSource(properties);
        } catch (Exception e) {
            System.err.println("加载驱动失败！");
        }

    }


    //获取链接
    protected static DruidPooledConnection getConnection(){
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            System.err.println("数据库连接失败！");
        }
        return null;
    }


    //关闭资源
    protected static void closeRsc
            (Connection connection, Statement statement){
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
    protected static void closeRsc
            (Connection connection, Statement statement, ResultSet resultSet){
        closeRsc(connection,statement);
        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
