package djj.node.target;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/21.
 */
public class DesignApplicationNode extends TargetNode {

    static int count = 1;

    public DesignApplicationNode(ImageIcon icon){
        super(icon);
    }

    public DesignApplicationNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.DESIGN_APPLICATION+count++);
        super.initView();
    }


}
