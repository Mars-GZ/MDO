package djj.node.application;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/21.
 */
public class MatlabNode extends ApplicationNode {

    static int count = 1;

    public MatlabNode(ImageIcon icon){
        super(icon);
    }

    public MatlabNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.MATLAB+count++);
        super.initView();
    }


}
