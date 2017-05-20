package djj.menu;

import javax.swing.*;

/**
 * Created by mesmers on 2017/4/16.
 */
public abstract class MenuFactory {

   abstract JMenu createMenu(String name);

   abstract boolean removeMenu();

   protected static JMenu addMenu(String name,String[] items){
      JMenu menu = new JMenu(name);
      for(String file:items){
         JMenuItem item = new JMenuItem(file);
         menu.add(item);
      }
      return menu;
   }
}
