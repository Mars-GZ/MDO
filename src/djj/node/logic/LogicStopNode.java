package djj.node.logic;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/20.
 */
public class LogicStopNode extends LogicNode {

    static int count = 1;

    public LogicStopNode(ImageIcon icon){
        super(icon);
    }

    public LogicStopNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.LOGIC_STOP+count++);
        super.initView();
    }

}
