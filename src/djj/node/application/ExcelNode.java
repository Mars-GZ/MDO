package djj.node.application;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;
import djj.node.file.FileNode;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/21.
 */
public class ExcelNode extends ApplicationNode {

    static int count = 1;

    public ExcelNode(ImageIcon icon){
        super(icon);
    }

    public ExcelNode(){
        super();
    }

    @Override
    public void initView() {
        model = new NodeModel();
        model.setName(NodeConstant.EXCEL+count++);
        super.initView();
    }


}
