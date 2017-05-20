package djj.main.tab.workflow.var;

import djj.core.BaseJPanel;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mesmers on 2017/4/16.
 */
public class VariableTabView extends BaseJPanel {

    private String[] tabNames;

    private JTabbedPane jTabbedpane = new JTabbedPane();

    private BaseJPanel inputTab,outputTab;

    public BaseJPanel getInputTab() {
        return inputTab;
    }

    public void setInputTab(BaseJPanel inputTab) {
        this.inputTab = inputTab;
    }

    public BaseJPanel getOutputTab() {
        return outputTab;
    }

    public void setOutputTab(BaseJPanel outputTab) {
        this.outputTab = outputTab;
    }

    public VariableTabView() {
        tabNames = new String[]{"输入变量", "输出变量"};
    }

    @Override
    public void initView() {
        jTabbedpane.addTab(tabNames[0], inputTab);
        jTabbedpane.addTab(tabNames[1], outputTab);
        setLayout(new GridLayout(1, 1));
        add(jTabbedpane);
        inputTab.initView();
        outputTab.initView();
    }
}
