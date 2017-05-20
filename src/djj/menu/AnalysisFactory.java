package djj.menu;

import javax.swing.*;

/**
 * 分析工具菜单
 * Created by mesmers on 2017/4/16.
 */
public class AnalysisFactory extends MenuFactory{

    @Override
    JMenu createMenu(String name) {
        return AnalysisMenu.createAnalysisMenu(name);
    }

    @Override
    boolean removeMenu() {
        return false;
    }

    private static class AnalysisMenu{

        private static String[] items = new String[]{"Open Table Editing","Open DOE","Open RSM","Open MCDM","Open MVA"};

        public static JMenu createAnalysisMenu(String name){
            return MenuFactory.addMenu(name,items);
        }
    }
}
