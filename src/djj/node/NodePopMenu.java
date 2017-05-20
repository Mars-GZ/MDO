package djj.node;

import djj.node.data.InputNode;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by mesmers on 2017/5/4.
 */
public class NodePopMenu extends JPopupMenu implements ActionListener{

    private JMenuItem mDelItem,mOptionItem;
    private NodeJPanel mNodeJPanel;

    public NodeJPanel getmNodeJPanel() {
        return mNodeJPanel;
    }

    public void setmNodeJPanel(NodeJPanel mNodeJPanel) {
        this.mNodeJPanel = mNodeJPanel;
    }

    public NodePopMenu() {
        super();
        initView();
        initListener();
    }

    public void initView() {
        mDelItem = new JMenuItem("删除");
        mOptionItem = new JMenuItem("属性");
        add(mDelItem);
        add(mOptionItem);
    }

    public void initListener(){
        mDelItem.addActionListener(this);
        mOptionItem.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JMenuItem item = (JMenuItem) e.getSource();
        if (item==mDelItem){
            mNodeJPanel.del();
        }
        if (item==mOptionItem){
            switch (mNodeJPanel.getModel().getK_type()){
                case NodeConstant.INPUT_VAR:
                    InputNode node  = (InputNode) mNodeJPanel;
                    node.option();
                    break;
                default:
                    mNodeJPanel.option();
                    break;
            }
        }
    }
}
