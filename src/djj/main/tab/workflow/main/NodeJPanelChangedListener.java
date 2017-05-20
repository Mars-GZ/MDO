package djj.main.tab.workflow.main;

import djj.node.NodeJPanel;

/**
 * Created by mesmers on 2017/5/4.
 */
public interface NodeJPanelChangedListener {

    void delete(NodeJPanel nodeJPanel);

    void changeData(NodeJPanel nodeJPanel);

}
