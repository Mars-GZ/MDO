package djj.node.logic;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/20.
 */
public class LogicSwitchNode extends LogicNode {

    static int count = 1;

    public LogicSwitchNode(ImageIcon icon){
        super(icon);
    }

    public LogicSwitchNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.LOGIC_SWITCH+count++);
        super.initView();
    }


}
