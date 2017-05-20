package djj.node.file;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/21.
 */
public class OutFileTempNode  extends FileNode {

    static int count = 1;

    public OutFileTempNode(ImageIcon icon){
        super(icon);
    }

    public OutFileTempNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.OUT_TEMP+count++);
        super.initView();
    }


}