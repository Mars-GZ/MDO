package djj.node.target;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;
import djj.node.NodeJPanel;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/21.
 */
public class TargetNode  extends NodeJPanel {

    public TargetNode(ImageIcon icon){
        super(icon);
    }

    public TargetNode(){
        super();
    }

    @Override
    public void initView() {
        model.setType(NodeConstant.TARGET_TYPE);
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
