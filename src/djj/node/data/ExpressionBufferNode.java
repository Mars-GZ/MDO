package djj.node.data;

import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;

import javax.swing.*;

/**
 * Created by mesmers on 2017/5/20.
 */
public class ExpressionBufferNode extends DataNode{

        static int count = 1;

        public ExpressionBufferNode(ImageIcon icon) {
            super(icon);
        }

        public ExpressionBufferNode() {
            super();
        }

        @Override
        public void initView() {
            model = new NodeModel();
            model.setName(NodeConstant.EXPRESSION_BUFFER + count++);
            super.initView();
        }

        @Override
        public void option() {

        }

        @Override
        public void ok(NodeModel model) {

        }

}
