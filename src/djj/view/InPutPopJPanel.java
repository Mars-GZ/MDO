package djj.view;

import djj.core.BaseJPanel;
import djj.main.tab.workflow.model.InputNodeModel;

import javax.swing.border.EmptyBorder;

/**
 * Created by mesmers on 2017/5/5.
 */
public abstract class InPutPopJPanel extends BaseJPanel {

    protected int defaultWidth=786,defaultHeight=70;

    protected InputNodeModel model;

    protected String backColor = "#F0F0F0";

    protected InPutUpdateListener mInputUpdateListener;

    public InPutUpdateListener getmInputUpdateListener() {
        return mInputUpdateListener;
    }

    public void setmInputUpdateListener(InPutUpdateListener mInputUpdateListener) {
        this.mInputUpdateListener = mInputUpdateListener;
    }

    public InputNodeModel getModel() {
        return model;
    }

    public void setModel(InputNodeModel model) {
        this.model = model;
    }

    public InPutPopJPanel(){
        setBorder(new EmptyBorder(7,7,7,7));
    }

    @Override
    public void initView() {
       initTitle();
    }

    abstract void initTitle();

    public abstract void save();

    public abstract void update();
}
