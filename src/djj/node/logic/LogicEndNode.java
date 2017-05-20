package djj.node.logic;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/20.
 */
public class LogicEndNode extends LogicNode {

    static int count = 1;

    public LogicEndNode(ImageIcon icon){
        super(icon);
    }

    public LogicEndNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.LOGIC_END+count++);
        super.initView();
    }

}
