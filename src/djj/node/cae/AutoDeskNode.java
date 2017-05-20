package djj.node.cae;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;
import djj.node.cad.CADNode;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/21.
 */
public class AutoDeskNode extends CAENode {

    static int count = 1;

    public AutoDeskNode(ImageIcon icon){
        super(icon);
    }

    public AutoDeskNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.AUTO_DESK+count++);
        super.initView();
    }


}
