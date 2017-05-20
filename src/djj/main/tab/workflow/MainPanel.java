package djj.main.tab.workflow;

import djj.core.BaseJPanel;
import djj.core.GBC;

import java.awt.*;

/**
 * 右边的Main
 * Created by mesmers on 2017/4/16.
 */
public class MainPanel extends BaseJPanel {

    private BaseJPanel mainPanel;
    private BaseJPanel toolPanel;

    public BaseJPanel getMainPanel() {
        return mainPanel;
    }

    public void setMainPanel(BaseJPanel mainPanel) {
        this.mainPanel = mainPanel;
    }

    public BaseJPanel getToolPanel() {
        return toolPanel;
    }

    public void setToolPanel(BaseJPanel toolPanel) {
        this.toolPanel = toolPanel;
    }

    public MainPanel(){
        setLayout(new GridBagLayout());
    }

    public void initView(){
        add(mainPanel,new GBC(0,0,1,2).setFill(GBC.BOTH).setWeight(1,100));
        add(toolPanel,new GBC(0,2,1,1).setFill(GBC.BOTH).setWeight(1,1));
        mainPanel.initView();
        toolPanel.initView();
    }
}
