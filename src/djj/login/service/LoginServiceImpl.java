package djj.login.service;

import djj.login.bean.Login;
import djj.login.dao.LoginDAO;

import java.util.List;

/**
 * Created by mesmers on 2017/3/11.
 */
public class LoginServiceImpl implements LoginService {

    private LoginDAO loginDAO;

    public LoginDAO getLoginDAO() {
        return loginDAO;
    }

    public void setLoginDAO(LoginDAO loginDAO) {
        this.loginDAO = loginDAO;
    }

    @Override
    public Login login(Login login) {
        List<Login> logins = loginDAO.findLoginByProperty(new String[]{"userName","password"}, new Object[]{login.getUserName(), login.getPassword()});
        if (!logins.isEmpty() && logins.size() > 0)
            return logins.get(0);
        return null;
    }

    @Override
    public boolean editPsw(Login login) {
        try {
            Login result = loginDAO.findLoginById(login.getId());
            result.setPassword(login.getPassword());
            loginDAO.merge(result);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

}
