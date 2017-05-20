package djj.node.file;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/21.
 */
public class TranslateFileNode extends FileNode {

    static int count = 1;

    public TranslateFileNode(ImageIcon icon){
        super(icon);
    }

    public TranslateFileNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.TRANSLATE_FILE+count++);
        super.initView();
    }


}
