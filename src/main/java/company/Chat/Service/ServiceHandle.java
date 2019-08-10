package company.Chat.Service;

import company.Chat.entity.User;
import company.Chat.dao.BaseDao;

/**
 * 服务器业务
 * 1.用户的注册验证
 * 2.用户的登陆验证
 */
public class ServiceHandle {
    private BaseDao baseDao = new BaseDao();

    //登陆验证
    public boolean service_loading(String userName,String password){
        User user = baseDao.Client_loading(userName,password);
        if (user == null) return false;
        return true;
    }

    //注册验证
    public boolean service_register(String userName,String password){
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        return baseDao.Client_register(user);
    }

}


