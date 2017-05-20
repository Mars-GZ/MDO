package djj.main.dao;

import djj.main.bean.Project;
import org.hibernate.Query;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import java.util.List;

/**
 * Created by mesmers on 2017/4/16.
 */
public class ProjectDAOImpl extends HibernateDaoSupport implements ProjectDAO {
    @Override
    public void save(Project project) {
        getHibernateTemplate().save(project);
    }

    @Override
    public Project getLast() {
        String sql = "from Project order by id desc";
        Query query = getSession().createQuery(sql);
        query.setFirstResult(0);
        query.setMaxResults(1);
        List projects = query.list();
        return (projects==null||projects.isEmpty())?null:(Project) projects.get(0);
    }

    @Override
    public Project findLoginById(int id) {
        try {
            return (Project) getHibernateTemplate().get(Project.class, id);
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Project> findProjectByProperty(String[] properties, Object[] values) {
        String m = "";
        for (int i = 0; i < properties.length; i++) {
            if (i != properties.length - 1)
                m += "p." + properties[i] + "= ? and ";
            else
                m += "p." + properties[i] + "= ?";
        }
        try {
            String sql = "from Project p where "+m;
            List<Project> projects = getHibernateTemplate().find(sql,values);
            return projects;
        } catch (RuntimeException e) {
            throw e;
        }
    }

    @Override
    public List<Project> findAll() {
        try {
            String sql = "from Project";
            List<Project> projects = getHibernateTemplate().find(sql);
            return projects;
        }catch (RuntimeException e){
            throw e;
        }
    }

    @Override
    public Project merge(Project project) {
        try {
            Project result = (Project) getHibernateTemplate().merge(project);
            return result;
        }catch (RuntimeException e){
            throw e;
        }
    }
}
