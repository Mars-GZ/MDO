package djj.node.data;


import djj.main.tab.workflow.model.InputNodeModel;
import djj.main.tab.workflow.model.NodeModel;
import djj.node.NodeConstant;
import djj.view.*;

import javax.swing.*;
import java.awt.*;

/**
 * Created by mesmers on 2017/4/20.
 */
public class InputNode extends DataNode {

    static int count = 1;

    public InputNode(ImageIcon icon) {
        super(icon);
    }

    public InputNode() {
        super();
    }

    @Override
    public void initView() {
        model = new InputNodeModel();
        model.setName(NodeConstant.INPUT + count++);
        super.initView();
    }

    @Override
    public void option() {
        InputPopJFrame frame = new InputPopJFrame();
        try {
            frame.setModel(((InputNodeModel) model).clone());
            frame.setmSelectListener(this);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        frame.initView();
        frame.setVisible(true);
    }

    @Override
    public void ok(NodeModel model) {
        ((InputNodeModel)this.model).save((InputNodeModel) model);
        setToolTipText(model.getDescription());
        mNodeJPanelChangedListener.changeData(this);
    }

    @Override
    public void cancel() {

    }

    static class InputPopJFrame extends JFrame implements InPutUpdateListener, SelectListener {

        private InputNodeModel model;

        private InPutPopJPanel var, range, base, mordo;

        private SelectPopJPanel select;

        private MySelectListener mSelectListener;

        public MySelectListener getmSelectListener() {
            return mSelectListener;
        }

        public void setmSelectListener(MySelectListener mSelectListener) {
            this.mSelectListener = mSelectListener;
        }

        public InputNodeModel getModel() {
            return model;
        }

        public void setModel(InputNodeModel model) {
            this.model = model;
        }

        public InputPopJFrame() {
            addClosed();
            setLayout(new GridLayout(5,1));

            Toolkit kit = Toolkit.getDefaultToolkit();    // 定义工具包
            Dimension screenSize = kit.getScreenSize();   // 获取屏幕的尺寸
            int screenWidth = screenSize.width / 2;         // 获取屏幕的宽
            int screenHeight = screenSize.height / 2;       // 获取屏幕的高
            setSize(800, screenSize.height);
            int height = this.getHeight();
            int width = this.getWidth();

            setLocation(screenWidth - width / 2, 0);
            setTitle("输入变量属性");
        }

        public void initView() {
            var = new InputVarPopJPanel();
            initInput(var);
            range = new InputVarRangePopJPanel();
            initInput(range);
            base = new InputVarBasePopJPanel();
            initInput(base);
            mordo = new InputVarMORDOPopJPanel();
            initInput(mordo);
            select = new SelectPopJPanel();
            initInput(select);
            select.setmSelectListener(this);
        }

        private void initInput(InPutPopJPanel jPanel) {
            jPanel.setModel(model);
            jPanel.initView();
            jPanel.setmInputUpdateListener(this);
            add(jPanel);
        }

        /**
         * 关闭按钮相应
         */
        protected void addClosed() {
            setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        }

        @Override
        public void update() {
            base.update();
        }

        @Override
        public void ok() {
            var.save();
            range.save();
            base.save();
            mordo.save();
            mSelectListener.ok(model);
            dispose();
        }

        @Override
        public void cancel() {
            mSelectListener.cancel();
            dispose();
        }
    }
}
