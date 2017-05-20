package djj.main.tab.workflow.tree;

import djj.core.BaseJPanel;
import djj.main.tab.workflow.model.NodeModel;
import djj.main.tab.workflow.main.TreeClickListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreeNode;
import java.awt.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mesmers on 2017/4/16.
 */
public class WorkFlowTreePanel extends BaseJPanel implements TreeNodeListener {

    private Box box;
    private JTree root;
    private Map<String, TreeNode> typeTree;
    private Map<Integer,DefaultMutableTreeNode> treeNode;
    private DefaultMutableTreeNode first;

    private TreeClickListener mTreeClickListener;

    public TreeClickListener getmTreeClickListener() {
        return mTreeClickListener;
    }

    public void setmTreeClickListener(TreeClickListener mTreeClickListener) {
        this.mTreeClickListener = mTreeClickListener;
    }

    public WorkFlowTreePanel() {
        Border titleBorder1 = BorderFactory.createTitledBorder("工作流树");
        setBorder(titleBorder1);
        setLayout(new GridLayout(1, 1));
    }

    @Override
    public void initView() {
        typeTree = new HashMap<>();
        treeNode = new HashMap<>();
        createTree();

        box = Box.createHorizontalBox();
        box.add(new JScrollPane(root), BorderLayout.EAST);
        add(box);
    }

    private void createTree() {
        first = new DefaultMutableTreeNode("工作流树");
        root = new JTree(first);

        root.addTreeSelectionListener((e) -> {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.getNewLeadSelectionPath().getLastPathComponent();
            mTreeClickListener.click((String)node.getUserObject());
        });
    }

    @Override
    public void addTreeNode(NodeModel model) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) typeTree.get(model.getType());
        if (node == null) {
            node = new DefaultMutableTreeNode(model.getType());
            typeTree.put(model.getType(), node);
            first.add(node);
        }
        DefaultMutableTreeNode child = new DefaultMutableTreeNode(model.getName());
        treeNode.put(model.getId(),child);
        node.add(child);
        root.updateUI();
    }

    @Override
    public boolean removeTreeNode(NodeModel model) {
        DefaultMutableTreeNode node = (DefaultMutableTreeNode) typeTree.get(model.getType());
        if (node == null)
            return true;
        int count = node.getChildCount();
        for (int i = 0; i < count; i++) {
            DefaultMutableTreeNode d = (DefaultMutableTreeNode) node.getChildAt(i);
            if (d.getUserObject() == model.getName()) {
                node.remove(i);
                treeNode.remove(model.getId());
                break;
            }
        }
        if (node.getChildCount()==0){
            typeTree.remove(model.getType());
            first.remove(node);
        }
        root.updateUI();
        return true;
    }

    @Override
    public void updateTreeNode(NodeModel model) {
        DefaultMutableTreeNode node = treeNode.get(model.getId());
        node.setUserObject(model.getName());
        root.updateUI();
    }
}
