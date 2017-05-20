package djj.node.target;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/21.
 */
public class DesignConstraintsGradientNode extends TargetNode {

    static int count = 1;

    public DesignConstraintsGradientNode(ImageIcon icon){
        super(icon);
    }

    public DesignConstraintsGradientNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.DESIGN_CONSTRAINTS_GRADIENT+count++);
        super.initView();
    }


}
