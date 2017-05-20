package djj.node.cad;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;
import djj.node.NodeJPanel;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/21.
 */
public class CADNode extends NodeJPanel {

    public CADNode(ImageIcon icon){
        super(icon);
    }

    public CADNode(){
        super();
    }

    @Override
    public void initView() {
        model.setType(NodeConstant.CAD_TYPE);
        super.initView();
    }

    @Override
    public void option() {

    }

    @Override
    public void ok(NodeModel model) {

    }

    @Override
    public void cancel() {

    }
}

