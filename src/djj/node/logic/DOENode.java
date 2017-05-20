package djj.node.logic;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/20.
 */
public class DOENode extends LogicNode {

    static int count = 1;

    public DOENode(ImageIcon icon){
        super(icon);
    }

    public DOENode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.DOE+count++);
        super.initView();
    }

}
