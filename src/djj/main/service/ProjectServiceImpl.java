package djj.main.service;

import djj.main.bean.Project;
import djj.main.dao.ProjectDAO;

/**
 * Created by mesmers on 2017/4/16.
 */
public class ProjectServiceImpl implements ProjectService {

    private ProjectDAO projectDAO;

    public ProjectDAO getProjectDAO() {
        return projectDAO;
    }

    public void setProjectDAO(ProjectDAO projectDAO) {
        this.projectDAO = projectDAO;
    }

    @Override
    public Project getLast() {
        return projectDAO.getLast();
    }

    @Override
    public boolean edit(Project project) {
        return projectDAO.merge(project)!=null;
    }
}
