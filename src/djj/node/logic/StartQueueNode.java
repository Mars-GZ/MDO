package djj.node.logic;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/20.
 */
public class StartQueueNode extends LogicNode {

    static int count = 1;

    public StartQueueNode(ImageIcon icon){
        super(icon);
    }

    public StartQueueNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.START_QUEUE+count++);
        super.initView();
    }

}
