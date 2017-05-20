package djj.node.application;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;
import djj.node.NodeJPanel;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/21.
 */
public class ApplicationNode extends NodeJPanel {

    public ApplicationNode(ImageIcon icon){
        super(icon);
    }

    public ApplicationNode(){
        super();
    }

    @Override
    public void initView() {
        model.setType(NodeConstant.APP_TYPE);
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
