package djj.node.file;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/21.
 */
public class SupportFileNode extends FileNode {

    static int count = 1;

    public SupportFileNode(ImageIcon icon){
        super(icon);
    }

    public SupportFileNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.SUPPORT_FILE+count++);
        super.initView();
    }


}
