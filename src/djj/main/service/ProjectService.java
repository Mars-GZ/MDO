package djj.main.service;

import djj.main.bean.Project;

/**
 * Created by mesmers on 2017/4/16.
 */
public interface ProjectService {
    Project getLast();//查询接口
    boolean edit(Project project);//修改项目接口
}
