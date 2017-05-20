package djj.view;

import djj.main.tab.workflow.model.InputNodeModel;
import djj.main.tab.workflow.model.NodeModel;

/**
 * Created by mesmers on 2017/5/7.
 */
public interface MySelectListener {

    void ok(NodeModel model);
    void cancel();
}
