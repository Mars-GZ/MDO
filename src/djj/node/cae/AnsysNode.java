package djj.node.cae;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/21.
 */
public class AnsysNode extends CAENode {

    static int count = 1;

    public AnsysNode(ImageIcon icon){
        super(icon);
    }

    public AnsysNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.ANSYS+count++);
        super.initView();
    }


}
