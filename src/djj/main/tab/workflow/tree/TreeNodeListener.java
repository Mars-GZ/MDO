package djj.main.tab.workflow.tree;

import djj.main.tab.workflow.model.NodeModel;

/**
 * Created by mesmers on 2017/4/23.
 */
public interface TreeNodeListener {

    void addTreeNode(NodeModel model);

    boolean removeTreeNode(NodeModel model);

    void updateTreeNode(NodeModel model);

}
