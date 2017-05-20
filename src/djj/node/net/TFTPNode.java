package djj.node.net;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/21.
 */
public class TFTPNode extends NetNode {

    static int count = 1;

    public TFTPNode(ImageIcon icon){
        super(icon);
    }

    public TFTPNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.TFTP+count++);
        super.initView();
    }


}

