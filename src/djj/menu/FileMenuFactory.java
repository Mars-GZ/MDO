package djj.menu;

import javax.swing.*;

/**
 * 文件菜单
 * Created by mesmers on 2017/4/16.
 */
public class FileMenuFactory extends MenuFactory {

    /**
     * 创建文件一个菜单
     * @param name
     * @return
     */
    @Override
    JMenu createMenu(String name) {
        return FileMenu.createFileMenu(name);
    }

    @Override
    boolean removeMenu() {
        return false;
    }

    private static class FileMenu{

        private static String[] items = new String[]{"新建","打开","在新窗口打开","导入","导出","离开"};

        public static JMenu createFileMenu(String name){
            return MenuFactory.addMenu(name,items);
        }
    }
}
