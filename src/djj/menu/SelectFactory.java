package djj.menu;

import javax.swing.*;

/**
 * Created by mesmers on 2017/4/16.
 */
public class SelectFactory extends MenuFactory {

    @Override
    JMenu createMenu(String name) {
        return SelectMenu.createSelectMenu(name);
    }

    @Override
    boolean removeMenu() {
        return false;
    }

    private static class SelectMenu{

        private static String[] files = new String[]{"选择标记","选择未被标记","选择种类","切换选择"};

        public static JMenu createSelectMenu(String name){
            JMenu menu = MenuFactory.addMenu(name,files);
            return menu;
        }
    }
}
