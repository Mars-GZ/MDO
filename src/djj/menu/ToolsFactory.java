package djj.menu;

import javax.swing.*;

/**
 * Created by mesmers on 2017/4/16.
 */
public class ToolsFactory extends MenuFactory {
    @Override
    JMenu createMenu(String name) {
        return ToolsMenu.createToolsMenu(name);
    }

    @Override
    boolean removeMenu() {
        return false;
    }

    private static class ToolsMenu{

        private static String[] items = new String[]{"许可证管理","布局管理","下载MDO插件","下载驱动插件","配置SOMO连接","开启MODELER进程"};

        public static JMenu createToolsMenu(String name){
            return MenuFactory.addMenu(name,items);
        }
    }
}
