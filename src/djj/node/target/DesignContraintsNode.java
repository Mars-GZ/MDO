package djj.node.target;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/21.
 */
public class DesignContraintsNode extends TargetNode {

    static int count = 1;

    public DesignContraintsNode(ImageIcon icon){
        super(icon);
    }

    public DesignContraintsNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.DESIGN_CONSTRAINTS+count++);
        super.initView();
    }


}
