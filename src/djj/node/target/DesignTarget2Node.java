package djj.node.target;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/21.
 */
public class DesignTarget2Node extends TargetNode {

    static int count = 1;

    public DesignTarget2Node(ImageIcon icon){
        super(icon);
    }

    public DesignTarget2Node(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.DESIGN_TARGET_2+count++);
        super.initView();
    }


}
