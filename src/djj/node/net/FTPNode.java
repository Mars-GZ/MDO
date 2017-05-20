package djj.node.net;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;
import djj.node.cad.CADNode;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/21.
 */
public class FTPNode extends NetNode {

    static int count = 1;

    public FTPNode(ImageIcon icon){
        super(icon);
    }

    public FTPNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.FTP+count++);
        super.initView();
    }


}
