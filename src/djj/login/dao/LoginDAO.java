package djj.login.dao;
import djj.login.bean.Login;

import java.util.List;

/**
 * Created by mesmers on 2017/3/11.
 */
public interface LoginDAO {

    void save(Login login);//向数据库里增加一个管理员
    Login findLoginById(int id);//根据id来查询管理员
    List<Login> findLoginByProperty(String[] properties, Object[] value);//根据用户名密码来查询管理员
    List<Login> findAll();//得到所有管理员
    Login merge(Login login);//更新一条管理员信息
}
