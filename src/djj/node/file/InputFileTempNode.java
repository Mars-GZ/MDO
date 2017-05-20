package djj.node.file;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/20.
 */
public class InputFileTempNode extends FileNode{

    static int count = 1;

    public InputFileTempNode(ImageIcon icon){
        super(icon);
    }

    public InputFileTempNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.INPUT_TEMP+count++);
        super.initView();
    }


}
