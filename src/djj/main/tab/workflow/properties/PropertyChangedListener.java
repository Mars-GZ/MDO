package djj.main.tab.workflow.properties;

import djj.main.tab.workflow.model.NodeModel;

/**
 * Created by mesmers on 2017/5/3.
 */
public interface PropertyChangedListener {

    void change(NodeModel model);

    void update();

    void reset();

}
