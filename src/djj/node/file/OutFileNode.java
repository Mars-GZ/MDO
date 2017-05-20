package djj.node.file;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/21.
 */
public class OutFileNode extends FileNode {

    static int count = 1;

    public OutFileNode(ImageIcon icon){
        super(icon);
    }

    public OutFileNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.OUT_FILE+count++);
        super.initView();
    }


}
