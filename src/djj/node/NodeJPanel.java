package djj.node;

import djj.core.BaseJPanel;
import djj.main.tab.workflow.main.LineModel;
import djj.main.tab.workflow.main.MainChangedCircleJPanelListener;
import djj.main.tab.workflow.model.NodeModel;
import djj.main.tab.workflow.main.NodeJPanelChangedListener;
import djj.main.tab.workflow.properties.PropertyConstant;
import djj.main.tab.workflow.tree.TreeNodeListener;
import djj.view.CircleClickListener;
import djj.view.CircleJPanel;
import djj.view.MySelectListener;
import djj.view.NodeJPanelClickListener;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.*;

/**
 * Created by mesmers on 2017/4/20.
 */
public abstract class NodeJPanel extends BaseJPanel implements MySelectListener, CircleClickListener, MainChangedCircleJPanelListener {

    static int id = 1;
    private ImageIcon imageIcon;
    private int mWidth;
    private int mHeight;
    private JLabel mCLabel;//取消图标
    private Border mBorder;//边框
    private boolean isShow = true;
    protected NodePopMenu mPopMenu;

    private java.util.List<LineModel> lineModels = new ArrayList<>();
    private HashMap<CircleJPanel,LineModel> modelHashMap = new HashMap<>();

    private CircleJPanel mCurCircleJPanel;

    private NodeJPanelClickListener mCircleClickListener;

    public NodeJPanelClickListener getmCircleClickListner() {
        return mCircleClickListener;
    }

    public void setmCircleClickListner(NodeJPanelClickListener mCircleClickListner) {
        this.mCircleClickListener = mCircleClickListner;
    }

    protected TreeNodeListener mTreeNodeListener;

    protected NodeJPanelChangedListener mNodeJPanelChangedListener;

    public NodeJPanelChangedListener getmNodeJPanelChangedListener() {
        return mNodeJPanelChangedListener;
    }

    public void setmNodeJPanelChangedListener(NodeJPanelChangedListener mNodeJPanelChangedListener) {
        this.mNodeJPanelChangedListener = mNodeJPanelChangedListener;
    }

    public TreeNodeListener getmTreeNodeListener() {
        return mTreeNodeListener;
    }

    public void setmTreeNodeListener(TreeNodeListener mTreeNodeListener) {
        this.mTreeNodeListener = mTreeNodeListener;
    }

    protected NodeModel model;

    public NodeModel getModel() {
        return model;
    }

    public void setModel(NodeModel model) {
        this.model = model;
    }

    public NodeJPanel(ImageIcon icon) {
        imageIcon = icon;
        initView();
    }

    public NodeJPanel() {
        imageIcon = new ImageIcon();
        initView();
    }

    public NodePopMenu getmPopMenu() {
        return mPopMenu;
    }

    public void setmPopMenu(NodePopMenu mPopMenu) {
        this.mPopMenu = mPopMenu;
    }

    private CircleJPanel mLeft, mRight, mTop, mBottom;

    @Override
    public void initView() {
        model.setId(id++);

        mWidth = imageIcon.getIconWidth();
        mHeight = imageIcon.getIconHeight();
        setLayout(null);
        setSize(mWidth + 30, mHeight + 30);

        int height = mHeight + 30;
        int width = mWidth + 30;

        mLeft = new CircleJPanel(CircleJPanel.IN);
        mLeft.setmCircleClickListener(this);
        mRight = new CircleJPanel(CircleJPanel.OUT);
        mRight.setmCircleClickListener(this);
        mTop = new CircleJPanel(CircleJPanel.IN);
        mTop.setmCircleClickListener(this);
        mBottom = new CircleJPanel(CircleJPanel.OUT);
        mBottom.setmCircleClickListener(this);
        initCircle(mLeft, 0, height / 2 - 5, 10, 10);
        initCircle(mRight, width - 10, height / 2 - 5, 10, 10);
        initCircle(mTop, width / 2 - 5, 0, 10, 10);
        initCircle(mBottom, width / 2 - 5, height - 10, 10, 10);

        JLabel label = new JLabel(imageIcon);
        label.setBounds(25, 25, mWidth, mHeight);

//        ImageIcon imageIcon = new ImageIcon(Constant.SICON + "delete.png");
        JLabel label2 = new JLabel(model.getName());
        label2.setFont(new Font("Droid Sans", Font.PLAIN, 8));
        label2.setBounds(10, 10, mWidth + 19, 15);
        label2.setHorizontalAlignment(JLabel.LEFT);
        mCLabel = label2;

        add(label2);
        add(label);
        mBorder = BorderFactory.createLineBorder(Color.ORANGE, 1);
        setBorder(mBorder);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        mPopMenu = new NodePopMenu();
        mPopMenu.setmNodeJPanel(this);

        setToolTipText(model.getDescription());
    }

    private void initCircle(CircleJPanel jPanel, int x, int y, int width, int height) {
        jPanel.setBounds(x, y, width, height);
        add(jPanel);
    }

    public void updateLineModel(int x,int y){
        System.out.println(x+"   "+y);
        Set<CircleJPanel> circleJPanels = modelHashMap.keySet();
        for (CircleJPanel circleJPanel:circleJPanels){
            LineModel lineModel = modelHashMap.get(circleJPanel);
            if (circleJPanel.isStart()){
                lineModel.setStartX(lineModel.getStartX()+x);
                lineModel.setStartY(lineModel.getStartY()+y);
            }else{
                lineModel.setEndX(lineModel.getEndX()+x);
                lineModel.setEndY(lineModel.getEndY()+y);
            }
        }
    }

    public void update(String property, String value) {
        switch (property) {
            case PropertyConstant.NAME:
                setModelName(value);
                break;
            case PropertyConstant.BACK:
                setBackGroundColor(value);
                break;
            case PropertyConstant.TEXT_COLOR:
                setTextColor(value);
                break;
            case PropertyConstant.SHOW_TEXT:
                showText(value);
                break;
        }
    }

    public abstract void option();

    public void setModelName(String name) {
        model.setName(name);
        mCLabel.setText(name);
        mCLabel.updateUI();
    }

    public void setBackGroundColor(String color) throws NumberFormatException {
        model.setBackColor(color);
        setBackground(Color.decode(color));
        updateUI();
    }

    public void setTextColor(String color) throws NumberFormatException {
        model.setTextColor(color);
        mCLabel.setForeground(Color.decode(color));
        mCLabel.updateUI();
    }

    public void showText(String isShow) {
        model.setShowText(isShow);
        if (isShow.equals("true")) {
            mCLabel.setVisible(true);
        } else
            mCLabel.setVisible(false);
        mCLabel.updateUI();
    }

    /**
     * 删除
     */
    public void del() {
        mNodeJPanelChangedListener.delete(this);
    }

    /**
     * 添加到工作流树中去
     */
    public void addTreeNode() {
        mTreeNodeListener.addTreeNode(model);
    }

    public void focusGained() {
        if (!isShow) {
            setBorder(mBorder);
            isShow = !isShow;
            repaint();
        }
    }

    public void focusLost() {
        if (isShow) {
            setBorder(null);
            isShow = !isShow;
            repaint();
        }
    }

    @Override
    public void click(int type, CircleJPanel circleJPanel) {
        if (modelHashMap.containsKey(circleJPanel)) {
            circleJPanel.refresh();
            return;
        }
        mCurCircleJPanel = circleJPanel;
        mCircleClickListener.click(circleJPanel.getX(), circleJPanel.getY(), type, this);
    }

    public void addLineModel(LineModel lineModel){
        modelHashMap.put(mCurCircleJPanel,lineModel);
        mCurCircleJPanel = null;
    }

    @Override
    public void cancel() {
        mCircleClickListener.cancel(this);
    }

    @Override
    public void draw(CircleJPanel circleJPanel) {
        mCurCircleJPanel = circleJPanel;
        if (modelHashMap.containsKey(circleJPanel)) {
            circleJPanel.refresh();
            return;
        }
        mCircleClickListener.draw(circleJPanel.getX(), circleJPanel.getY(),this);
    }

    @Override
    public void update(int type) {
        switch (type) {
            case CircleJPanel.IN:
                mLeft.setPressed(true);
                mTop.setPressed(true);
                break;
            case CircleJPanel.OUT:
                mRight.setPressed(true);
                mBottom.setPressed(true);
                break;
        }
    }

    @Override
    public void refresh() {
        mLeft.refresh();
        mRight.refresh();
        mTop.refresh();
        mBottom.refresh();
    }
}
