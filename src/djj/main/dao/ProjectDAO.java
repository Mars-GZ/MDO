package djj.main.dao;

import djj.main.bean.Project;

import java.util.List;

/**
 * Created by mesmers on 2017/4/16.
 */
public interface ProjectDAO {
    void save(Project project);//向数据库里保存一个历史项目
    Project getLast();//得到最后一条project
    Project findLoginById(int id);//根据id来查询历史项目
    List<Project> findProjectByProperty(String[] properties, Object[] value);//根据条件来查询管理员
    List<Project> findAll();//得到所有历史项目
    Project merge(Project project);//更新一条管理员信息
}
