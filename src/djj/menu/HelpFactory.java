package djj.menu;

import javax.swing.*;

/**
 * Created by mesmers on 2017/4/16.
 */
public class HelpFactory extends MenuFactory {

    @Override
    JMenu createMenu(String name) {
        return HelpMenu.createHelpMenu(name);
    }

    @Override
    boolean removeMenu() {
        return false;
    }

    private static class HelpMenu{
        private static String[] items = new String[]{"用户手册","浏览器教程","启动对话框","关于MDO"};

        public static JMenu createHelpMenu(String name){
            return MenuFactory.addMenu(name,items);
        }
    }
}
