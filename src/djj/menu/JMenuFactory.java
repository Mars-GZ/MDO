package djj.menu;

import javax.swing.*;

/**
 * Created by mesmers on 2017/4/16.
 */
public class JMenuFactory {

    public static JMenu createJMenu(String menuName){
        MenuFactory factory = null;
        switch (menuName){
            case MenuConstant.FILE:
                factory = new FileMenuFactory();
                break;
            case MenuConstant.EDIT:
                factory = new EditMenuFactory();
                break;
            case MenuConstant.PROJECT:
                factory = new ProjectFactory();
                break;
            case MenuConstant.WINDOW:
                factory = new WindowFactory();
                break;
            case MenuConstant.TOOLS:
                factory = new ToolsFactory();
                break;
            case MenuConstant.HELP:
                factory = new HelpFactory();
                break;
        }
        return factory==null?null:factory.createMenu(menuName);
    }

}
