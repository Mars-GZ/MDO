package djj.node.cad;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;
import djj.node.application.ApplicationNode;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/21.
 */
public class SolidWorksNode extends CADNode {

    static int count = 1;

    public SolidWorksNode(ImageIcon icon){
        super(icon);
    }

    public SolidWorksNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.SOLID_WORKS+count++);
        super.initView();
    }


}
