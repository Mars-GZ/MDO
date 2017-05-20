package djj.main.tab.workflow.var;

import djj.core.BaseJPanel;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by mesmers on 2017/4/16.
 */
public class OutputVariableTab extends BaseJPanel {

    public OutputVariableTab(){
        Border titleBorder1= BorderFactory.createTitledBorder("输出变量");
        setBorder(titleBorder1);
        setLayout(new GridLayout(1,1));
    }

    @Override
    public void initView() {
        String[] s = new String[]{" ","名称","变量类型","值","表达式","分配","缩放量","下限值"
                ,"上限值","中心值","delta值","Base","步","公差","格式","安排"};
        Object[][] data = new Object[20][16];
        for (int i = 0 ;i < 20 ;i++){
            for (int j = 0 ; j<16;j++) {
                data[i][j] = (int)Math.random()*100+""+i;
            }
        }
        JTable jTable = new JTable(data,s);
        add(new JScrollPane(jTable));
    }
}
