package djj.node.target;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;
import djj.node.cad.CADNode;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/21.
 */
public class AddConvexNode extends TargetNode {

    static int count = 1;

    public AddConvexNode(ImageIcon icon){
        super(icon);
    }

    public AddConvexNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.ADD_CONVEX+count++);
        super.initView();
    }


}
