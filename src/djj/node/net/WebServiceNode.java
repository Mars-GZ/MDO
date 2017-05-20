package djj.node.net;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/21.
 */
public class WebServiceNode extends NetNode {

    static int count = 1;

    public WebServiceNode(ImageIcon icon){
        super(icon);
    }

    public WebServiceNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.WebService+count++);
        super.initView();
    }


}

