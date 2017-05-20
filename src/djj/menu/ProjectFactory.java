package djj.menu;

import javax.swing.*;

/**
 * 项目菜单
 * Created by mesmers on 2017/4/16.
 */
public class ProjectFactory extends MenuFactory {

    @Override
    JMenu createMenu(String name) {
        return ProjectMenu.createProjectMenu(name);
    }

    @Override
    boolean removeMenu() {
        return false;
    }

    private static class ProjectMenu {
        public static final String[] items = new String[]{"工作流程", "运行分析", "设计空间", "运行/停止"};

        public static JMenu createProjectMenu(String name) {
            JMenu menu = MenuFactory.addMenu(name, items);
            menu.add(new AnalysisFactory().createMenu("分析工具"));
            return menu;
        }
    }
}
