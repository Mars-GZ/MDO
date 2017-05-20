package djj.core;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * Created by mesmers on 2017/4/16.
 */
public class BaseJFrame extends JFrame {


    /**
     * 关闭按钮相应
     */
    protected void addClosed(){
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int isDelete = JOptionPane.showConfirmDialog(null,"退出程序?","提示",JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE);
                if (isDelete==JOptionPane.YES_OPTION){
                    System.exit(0);
                }else
                    return;
            }
        });
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
    }

}
