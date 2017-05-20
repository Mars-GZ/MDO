package djj.node.script;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/21.
 */
public class JPythonNode extends ScriptNode {

    static int count = 1;

    public JPythonNode(ImageIcon icon){
        super(icon);
    }

    public JPythonNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.JPYTHON+count++);
        super.initView();
    }


}
