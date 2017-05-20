package djj.node.file;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;
import djj.node.NodeJPanel;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/20.
 */
public class FileNode  extends NodeJPanel {

    public FileNode(ImageIcon icon){
        super(icon);
    }

    public FileNode(){
        super();
    }

    @Override
    public void initView() {
        model.setType(NodeConstant.FILE_TYPE);
        super.initView();
    }

    @Override
    public void option() {

    }

    @Override
    public void ok(NodeModel model) {

    }

    @Override
    public void cancel() {

    }
}

