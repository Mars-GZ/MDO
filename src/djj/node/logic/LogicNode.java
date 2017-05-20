package djj.node.logic;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;
import djj.node.NodeJPanel;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/3.
 */
public class LogicNode extends NodeJPanel {

    public LogicNode(ImageIcon icon){
        super(icon);
    }

    public LogicNode(){
        super();
    }

    @Override
    public void initView() {
        model.setType(NodeConstant.LOGIC_TYPE);
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

