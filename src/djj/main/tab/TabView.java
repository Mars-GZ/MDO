package djj.main.tab;

import djj.core.Application;
import djj.core.BaseJPanel;
import djj.main.tab.workflow.WorkFlowTab;

import javax.swing.*;
import java.awt.*;

/**
 * 选项卡
 * Created by mesmers on 2017/4/16.
 */
public class TabView extends BaseJPanel {

    private String[] tabNames;

    private JTabbedPane jTabbedpane = new JTabbedPane();

    private BaseJPanel workFlowTab;

    public BaseJPanel getWorkFlowTab() {
        return workFlowTab;
    }

    public void setWorkFlowTab(BaseJPanel workFlowTab) {
        this.workFlowTab = workFlowTab;
    }

    public TabView() {
        tabNames = new String[]{"工作流程", "运行分析", "设计空间"};
    }

    @Override
    public void initView() {
        jTabbedpane.addTab(tabNames[0], workFlowTab);
        jTabbedpane.addTab(tabNames[1], new WorkFlowTab());
        jTabbedpane.addTab(tabNames[2], new WorkFlowTab());
        setLayout(new GridLayout(1, 1));
        add(jTabbedpane);
        workFlowTab.initView();
    }
}
