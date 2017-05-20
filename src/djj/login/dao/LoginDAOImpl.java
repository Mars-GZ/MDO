package djj.login.dao;

import djj.login.bean.Login;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;


/**
 * Created by mesmers on 2017/3/11.
 */
public class LoginDAOImpl extends HibernateDaoSupport implements LoginDAO {

    @Override
    public void save(Login login) {
        try {
            getHibernateTemplate().save(login);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public Login findLoginById(int id) {
        try {
            return (Login) getHibernateTemplate().get(Login.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Login> findLoginByProperty(String[] properties, Object[] values) {
        String m = "";
        for (int i = 0; i < properties.length; i++) {
            if (i != properties.length - 1)
                m += "l." + properties[i] + "= ? and ";
            else
                m += "l." + properties[i] + "= ?";
        }
        try {
            String sql = "from Login l where "+m;
            List<Login> logins = getHibernateTemplate().find(sql,values);
            return logins;
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Login> findAll() {
        try {
            String sql = "from Login";
            List<Login> logins = getHibernateTemplate().find(sql);
            return logins;
        }catch (RuntimeException e){
            throw e;
        }
    }

    @Override
    public Login merge(Login login) {
        try {
            Login result = (Login) getHibernateTemplate().merge(login);
            return result;
        }catch (RuntimeException e){
            throw e;
        }
    }
}
