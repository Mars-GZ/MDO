package djj.main.tab.workflow;

import djj.core.BaseJPanel;

import java.awt.*;

/**
 * 左边的WorkFlow
 * Created by mesmers on 2017/4/16.
 */
public class WorkFlowPanel extends BaseJPanel {

    private BaseJPanel treePanel;
    private BaseJPanel propertiesPanel;

    public BaseJPanel getTreePanel() {
        return treePanel;
    }

    public void setTreePanel(BaseJPanel treePanel) {
        this.treePanel = treePanel;
    }

    public BaseJPanel getPropertiesPanel() {
        return propertiesPanel;
    }

    public void setPropertiesPanel(BaseJPanel propertiesPanel) {
        this.propertiesPanel = propertiesPanel;
    }

    public WorkFlowPanel(){
        setLayout(new GridLayout(2,1));
    }

    public void initView(){
        add(treePanel);
        add(propertiesPanel);
        treePanel.initView();
        propertiesPanel.initView();
    }
}
