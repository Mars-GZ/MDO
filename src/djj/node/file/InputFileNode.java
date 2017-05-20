package djj.node.file;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/20.
 */
public class InputFileNode extends FileNode {

    static int count = 1;

    public InputFileNode(ImageIcon icon){
        super(icon);
    }

    public InputFileNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.INPUT_FILE+count++);
        super.initView();
    }


}
