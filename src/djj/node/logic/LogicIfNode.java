package djj.node.logic;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/4/23.
 */
public class LogicIfNode extends LogicNode{

    static int count = 1;

    public LogicIfNode(ImageIcon icon){
        super(icon);
    }

    public LogicIfNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.LOGIC_IF+count++);
        super.initView();
    }
}
