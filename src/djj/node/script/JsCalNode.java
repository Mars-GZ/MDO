package djj.node.script;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/21.
 */
public class JsCalNode extends ScriptNode {

    static int count = 1;

    public JsCalNode(ImageIcon icon){
        super(icon);
    }

    public JsCalNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.JS_CAL+count++);
        super.initView();
    }


}
