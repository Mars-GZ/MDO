package djj.view;

import djj.node.NodeJPanel;

/**
 * Created by mesmers on 2017/5/19.
 */
public interface NodeJPanelClickListener {

    void click(int x,int y,int type, NodeJPanel nodeJPanel);

    void cancel(NodeJPanel nodeJPanel);

    void draw(int x,int y,NodeJPanel nodeJPanel);

}
