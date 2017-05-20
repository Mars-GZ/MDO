package djj.node.net;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/21.
 */
public class SSHNode extends NetNode {

    static int count = 1;

    public SSHNode(ImageIcon icon){
        super(icon);
    }

    public SSHNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.SSH+count++);
        super.initView();
    }


}

