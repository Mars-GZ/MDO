package djj.node.data;

import djj.node.NodeConstant;
import djj.node.NodeJPanel;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/3.
 */
public abstract class DataNode extends NodeJPanel {

    public DataNode(ImageIcon icon){
        super(icon);
    }

    public DataNode(){
        super();
    }

    @Override
    public void initView() {
        model.setType(NodeConstant.DATA_TYPE);
        super.initView();
    }

}
