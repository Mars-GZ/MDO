package djj.node.net;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/21.
 */
public class SMTPNode extends NetNode {

    static int count = 1;

    public SMTPNode(ImageIcon icon){
        super(icon);
    }

    public SMTPNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.SMTP+count++);
        super.initView();
    }


}

