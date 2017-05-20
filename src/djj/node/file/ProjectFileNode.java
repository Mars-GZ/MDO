package djj.node.file;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/21.
 */
public class ProjectFileNode  extends FileNode {

    static int count = 1;

    public ProjectFileNode(ImageIcon icon){
        super(icon);
    }

    public ProjectFileNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.PROJECT_FILE+count++);
        super.initView();
    }


}

