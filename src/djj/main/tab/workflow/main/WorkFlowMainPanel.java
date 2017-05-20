package djj.main.tab.workflow.main;

import djj.core.BaseJPanel;
import djj.main.tab.workflow.model.InputNodeModel;
import djj.main.tab.workflow.model.NodeModel;
import djj.main.tab.workflow.properties.PropertyChangedListener;
import djj.main.tab.workflow.tree.TreeNodeListener;
import djj.main.tab.workflow.var.InputVarChangedListener;
import djj.node.*;
import djj.view.CircleJPanel;
import djj.view.NodeJPanelClickListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.*;


/**
 * Created by mesmers on 2017/4/16.
 */
public class WorkFlowMainPanel extends BaseJPanel implements ChangeMouseListener, TreeClickListener, PropertyDataChangedListener, NodeJPanelChangedListener, InputVarUpdatedListener, NodeJPanelClickListener {

    private JRadioButton mSelectBtn;
    private boolean isPaint = false;
    private PaintCallBack mPaintCallBack;

    private TreeNodeListener mTreeNodeListener;

    private MyListener myListener;
    private int mWidth, mHeight;
    private boolean isFirst = true;

    private LinkedList<NodeJPanel> mListNodeJPanel;
    private HashMap<Integer, NodeJPanel> mListNodeModel;

    private PropertyChangedListener mPropertyChangedListener;

    private InputVarChangedListener mInputVarChangedListener;

    public InputVarChangedListener getmInputVarChangedListener() {
        return mInputVarChangedListener;
    }

    public void setmInputVarChangedListener(InputVarChangedListener mInputVarChangedListener) {
        this.mInputVarChangedListener = mInputVarChangedListener;
    }

    public PropertyChangedListener getmPropertyChangedListener() {
        return mPropertyChangedListener;
    }

    public void setmPropertyChangedListener(PropertyChangedListener mPropertyChangedListener) {
        this.mPropertyChangedListener = mPropertyChangedListener;
    }

    public TreeNodeListener getmTreeNodeListener() {
        return mTreeNodeListener;
    }

    public void setmTreeNodeListener(TreeNodeListener mTreeNodeListener) {
        this.mTreeNodeListener = mTreeNodeListener;
    }

    public PaintCallBack getmPaintCallBack() {
        return mPaintCallBack;
    }

    public void setmPaintCallBack(PaintCallBack mPaintCallBack) {
        this.mPaintCallBack = mPaintCallBack;
    }

    public WorkFlowMainPanel() {
        Border titleBorder1 = BorderFactory.createTitledBorder("Main");
        setBorder(titleBorder1);
        setLayout(null);
        setBackground(Color.WHITE);

        mListNodeJPanel = new LinkedList<>();
        mListNodeModel = new HashMap<>();
    }

    private boolean isDrawing = false;

    @Override
    public void initView() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                if (e.getButton() == 3) {
                    if (isDrawing) {
                        isDrawing = false;
                        refresh();
                    }
                    return;
                }
                if (isFirst) {
                    myListener = new MyListener();
                    mWidth = getWidth();
                    mHeight = getHeight();
                    myListener.setmWidth(mWidth);
                    myListener.setmHeight(mHeight);
                    myListener.setmListNodeJPanel(mListNodeJPanel);
                    myListener.setmPropertyChangedListener(mPropertyChangedListener);
                    isFirst = !isFirst;
                }
                int x = e.getX();
                int y = e.getY();
                if (isPaint && x > 0 && y > 0 && x < getWidth() && y < getHeight()) {
                    NodeJPanel node = NodeFactory.createNode(mSelectBtn.getName(), (ImageIcon) mSelectBtn.getIcon());
                    if (node != null) {
                        sendAddMessage(node.getModel());
                        node.addMouseListener(myListener);
                        node.addMouseMotionListener(myListener);
                        node.setmTreeNodeListener(mTreeNodeListener);
                        node.setmCircleClickListner(WorkFlowMainPanel.this);
                        node.setmNodeJPanelChangedListener(WorkFlowMainPanel.this);
                        int width = node.getWidth();
                        int height = node.getHeight();
                        int startX = x - width / 2 < 0 ? 0 : x - width / 2;
                        int startY = y - height / 2 < 0 ? 0 : y - height / 2;
                        if (startX + width > mWidth) {
                            startX = mWidth - width;
                        }
                        if (startY + height > mHeight) {
                            startY = mHeight - height;
                        }
                        node.setBounds(startX, startY, width, height);
                        add(node);
                        node.addTreeNode();
                        mPropertyChangedListener.change(node.getModel());
                        mListNodeJPanel.add(node);
                        mListNodeModel.put(node.getModel().getId(), node);
                        mPaintCallBack.hasPaint();
                        repaint(startX, startY, width, height);
                    }
                    clearState();
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {
                for (NodeJPanel nodeJPanel : mListNodeJPanel) {
                    nodeJPanel.focusLost();
                }
            }
        });
        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (canChanged){
                    mCurLineModel.setEndX(e.getX());
                    mCurLineModel.setEndY(e.getY());
                    repaint();
                }
            }
        });
    }

    private void sendAddMessage(NodeModel model) {
        switch (model.getK_type()) {
            case NodeConstant.INPUT_VAR:
                mInputVarChangedListener.addInput((InputNodeModel) model);
                break;
        }
    }

    private void sendRemoveMessage(NodeModel model) {
        switch (model.getK_type()) {
            case NodeConstant.INPUT_VAR:
                mInputVarChangedListener.removeInput((InputNodeModel) model);
                break;
        }
    }

    private void sendUpdateMessage(NodeModel model) {
        switch (model.getK_type()) {
            case NodeConstant.INPUT_VAR:
                mInputVarChangedListener.updateInput((InputNodeModel) model);
                break;
        }
    }

    @Override
    public void addTool(JRadioButton jbtn) {
        mSelectBtn = jbtn;
        setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
        isPaint = true;
    }

    @Override
    public void clearState() {
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        isPaint = false;
    }

    @Override
    public void click(String name) {
        for (NodeJPanel nodeJPanel : mListNodeJPanel) {
            if (nodeJPanel.getModel().getName().equals(name)) {
                nodeJPanel.focusGained();
                mPropertyChangedListener.change(nodeJPanel.getModel());
            } else
                nodeJPanel.focusLost();
        }
    }

    @Override
    public void updateNode(String property, String value, int id) {
        NodeJPanel panel = getNode(id);
        if (panel != null) {
            panel.update(property, value);
            mTreeNodeListener.updateTreeNode(panel.getModel());
            sendUpdateMessage(panel.getModel());
        }
    }

    public NodeJPanel getNode(int id) {
        return mListNodeModel.get(id);
    }

    /**
     * 删除一个节点
     *
     * @param node
     */
    @Override
    public void delete(NodeJPanel node) {
        NodeJPanel nodeJPanel = mListNodeModel.get(node.getModel().getId());
        if (nodeJPanel != null) {
            mListNodeJPanel.remove(node);
            mTreeNodeListener.removeTreeNode(node.getModel());
            mPropertyChangedListener.reset();
            sendRemoveMessage(node.getModel());
            remove(node);
            updateUI();
            mListNodeModel.remove(node.getModel().getId());
        }
    }

    @Override
    public void changeData(NodeJPanel nodeJPanel) {
        mPropertyChangedListener.update();
        mTreeNodeListener.updateTreeNode(nodeJPanel.getModel());
        sendUpdateMessage(nodeJPanel.getModel());
    }

    private boolean canChanged = false;

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(Color.black);
        for (LineModel lineModel:lineModels){
            g.drawLine(lineModel.getStartX(),lineModel.getStartY(),lineModel.getEndX(),lineModel.getEndY());
        }
        if (isDrawing){
            g.drawLine(mCurLineModel.getStartX(),mCurLineModel.getStartY(),mCurLineModel.getEndX(),mCurLineModel.getEndY());
        }
    }

    /**
     * 输入变量改变 (其实没必要，因为都是指向同一个引用，不需要重复改变)
     *
     * @param type
     * @param value
     */
    @Override
    public void update(int id, int type, String value) {
//        InputNodeModel model = (InputNodeModel) mListNodeModel.get(id).getModel();
//        model.getMap().put(type,value);
    }

    private LineModel mCurLineModel;
    private NodeJPanel mFirstJPanel,mLastJPanel;

    @Override
    public void click(int x, int y, int type, NodeJPanel jPanel) {
        if (isDrawing){
            refresh();
        }
        mCurLineModel = new LineModel();
        mCurLineModel.setStartX(x+jPanel.getX());
        mCurLineModel.setStartY(y+jPanel.getY());
        mFirstJPanel = jPanel;
        isDrawing = true;
        canChanged = true;
        switch (type) {
            case CircleJPanel.IN:
                for (NodeJPanel jPanel1 : mListNodeJPanel) {
                    if (jPanel == jPanel1)
                        continue;
                    jPanel1.update(CircleJPanel.OUT);
                }
                break;
            case CircleJPanel.OUT:
                for (NodeJPanel jPanel1 : mListNodeJPanel) {
                    if (jPanel == jPanel1)
                        continue;
                    jPanel1.update(CircleJPanel.IN);
                }
                break;
        }
    }

    private java.util.List<LineModel> lineModels = new ArrayList<>();

    @Override
    public void cancel(NodeJPanel nodeJPanel) {
        for (NodeJPanel jPanel1 : mListNodeJPanel) {
            if (jPanel1 == nodeJPanel)
                continue;
            jPanel1.refresh();
        }
    }

    public void refresh() {
        for (NodeJPanel jPanel1 : mListNodeJPanel) {
            jPanel1.refresh();
        }
    }

    @Override
    public void draw(int x, int y,NodeJPanel nodeJPanel) {
        mCurLineModel.setEndX(x+nodeJPanel.getX());
        mCurLineModel.setEndY(y+nodeJPanel.getY());
        mLastJPanel = nodeJPanel;
        lineModels.add(mCurLineModel);
        canChanged = false;
        repaint();
        isDrawing = false;
        mFirstJPanel.addLineModel(mCurLineModel);
        mLastJPanel.addLineModel(mCurLineModel);
        refresh();
    }

    private static class MyListener extends MouseAdapter {
        //这两组x和y为鼠标点下时在屏幕的位置和拖动时所在的位置
        int newX, newY, oldX, oldY;
        //这两个坐标为组件当前的坐标
        int startX, startY;

        private LinkedList<NodeJPanel> mListNodeJPanel;

        private int mWidth, mHeight;

        private PropertyChangedListener mPropertyChangedListener;

        public PropertyChangedListener getmPropertyChangedListener() {
            return mPropertyChangedListener;
        }

        public void setmPropertyChangedListener(PropertyChangedListener mPropertyChangedListener) {
            this.mPropertyChangedListener = mPropertyChangedListener;
        }

        public LinkedList<NodeJPanel> getmListNodeJPanel() {
            return mListNodeJPanel;
        }

        public void setmListNodeJPanel(LinkedList<NodeJPanel> mListNodeJPanel) {
            this.mListNodeJPanel = mListNodeJPanel;
        }

        public int getmWidth() {
            return mWidth;
        }

        public void setmWidth(int mWidth) {
            this.mWidth = mWidth;
        }

        public int getmHeight() {
            return mHeight;
        }

        public void setmHeight(int mHeight) {
            this.mHeight = mHeight;
        }

        @Override
        public void mousePressed(MouseEvent e) {
            if (e.getButton() == 3) {
                NodeJPanel p = (NodeJPanel) e.getSource();
                p.getmPopMenu().show(p, e.getX(), e.getY());
            }
            //此为得到事件源组件
            Component cp = (Component) e.getSource();
            //当鼠标点下的时候记录组件当前的坐标与鼠标当前在屏幕的位置
            startX = cp.getX();
            startY = cp.getY();
            oldX = e.getXOnScreen();
            oldY = e.getYOnScreen();

            NodeJPanel jPanel = (NodeJPanel) e.getSource();
            for (NodeJPanel nodeJPanel : mListNodeJPanel) {
                if (jPanel != nodeJPanel)
                    nodeJPanel.focusLost();
                else {
                    nodeJPanel.focusGained();
                    mPropertyChangedListener.change(nodeJPanel.getModel());
                }
            }
        }

        private int lastX,lastY;

        @Override
        public void mouseDragged(MouseEvent e) {
            Component cp = (Component) e.getSource();
            lastX = cp.getX();
            lastY = cp.getY();
            NodeJPanel nodeJPanel = (NodeJPanel) cp;
            //拖动的时候记录新坐标
            newX = e.getXOnScreen();
            newY = e.getYOnScreen();
            nodeJPanel.getParent().repaint();
            int x = startX + (newX - oldX);
            int y = startY + (newY - oldY);
            x = x < 0 ? 0 : (x > (mWidth - cp.getWidth()) ? mWidth - cp.getWidth() : x);
            y = y < 0 ? 0 : (y > (mHeight - cp.getHeight()) ? mHeight - cp.getHeight() : y);
            //设置bounds,将点下时记录的组件开始坐标与鼠标拖动的距离相加
            cp.setBounds(x, y, cp.getWidth(), cp.getHeight());
            nodeJPanel.updateLineModel(x-lastX,y-lastY);
        }

    }
}
