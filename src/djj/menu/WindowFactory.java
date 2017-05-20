package djj.menu;

import javax.swing.*;

/**
 * Created by mesmers on 2017/4/16.
 */
public class WindowFactory extends MenuFactory {

    @Override
    JMenu createMenu(String name) {
        return WindowMenu.createWindowMenu(name);
    }

    @Override
    boolean removeMenu() {
        return false;
    }

    private static class WindowMenu{

        private static String[] items = new String[]{"新建MDO窗口","状态栏","自定义视图"};

        public static JMenu createWindowMenu(String name){
            return MenuFactory.addMenu(name,items);
        }
    }
}
