package djj.login.service;

import djj.login.bean.Login;

/**
 * Created by mesmers on 2017/3/11.
 */
public interface LoginService {

    Login login(Login login);//登录接口
    boolean editPsw(Login login);//修改密码接口

}
