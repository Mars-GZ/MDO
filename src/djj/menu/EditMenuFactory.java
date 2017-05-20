package djj.menu;

import javax.swing.*;

/**
 * 编辑菜单
 * Created by mesmers on 2017/4/16.
 */
public class EditMenuFactory extends MenuFactory {

    /**
     * 创建文件一个菜单
     * @param name
     * @return
     */
    @Override
    JMenu createMenu(String name) {
        return EditMenu.createEditMenu(name);
    }

    @Override
    boolean removeMenu() {
        return false;
    }

    private static class EditMenu{

        private static String[] items = new String[]{"上一步","下一步","剪切","复制","粘贴","删除","查找","外观"};

        public static JMenu createEditMenu(String name){
            JMenu menu = MenuFactory.addMenu(name,items);
            menu.add(new SelectFactory().createMenu("选择"));
            return menu;
        }
    }
}

