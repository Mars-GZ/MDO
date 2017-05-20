package djj.main.tab.workflow.var;

import djj.main.tab.workflow.model.InputNodeModel;

/**
 * Created by mesmers on 2017/5/4.
 */
public interface InputVarChangedListener {

    void addInput(InputNodeModel model);

    void removeInput(InputNodeModel model);

    void updateInput(InputNodeModel model);
}
