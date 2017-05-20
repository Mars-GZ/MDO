package djj.main.tab.workflow;

import djj.core.BaseJPanel;
import djj.core.GBC;

import java.awt.*;

/**
 * 工作流程选项卡
 * Created by mesmers on 2017/4/16.
 */
public class WorkFlowTab extends BaseJPanel {

    private BaseJPanel workFlow, main,variableTabView;

    public BaseJPanel getVariableTabView() {
        return variableTabView;
    }

    public void setVariableTabView(BaseJPanel variableTabView) {
        this.variableTabView = variableTabView;
    }

    public BaseJPanel getWorkFlow() {
        return workFlow;
    }

    public void setWorkFlow(BaseJPanel workFlow) {
        this.workFlow = workFlow;
    }

    public BaseJPanel getMain() {
        return main;
    }

    public void setMain(BaseJPanel main) {
        this.main = main;
    }

    public WorkFlowTab() {
        GridBagLayout layout = new GridBagLayout();
        setLayout(layout);
    }

    //初始化WorkFlowTab
    public void initView(){
        add(workFlow, new GBC(0, 0).
                setFill(GBC.BOTH).setWeight(2,2));
        add(main, new GBC(1, 0).setWeight(6,2).
                setFill(GBC.BOTH));
        add(variableTabView,new GBC(0,1,2,1).setFill(GBC.BOTH).setWeight(11,1));
        workFlow.initView();
        main.initView();
        variableTabView.initView();
    }
}
