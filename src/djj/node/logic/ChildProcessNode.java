package djj.node.logic;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/20.
 */
public class ChildProcessNode extends LogicNode {

    static int count = 1;

    public ChildProcessNode(ImageIcon icon){
        super(icon);
    }

    public ChildProcessNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.CHILd_PROCESS+count++);
        super.initView();
    }

}
