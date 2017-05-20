package djj.view;


import djj.main.tab.workflow.model.InputNodeModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.text.DecimalFormat;

/**
 * 输入变量范围属性
 * Created by mesmers on 2017/5/5.
 */
public class InputVarRangePopJPanel extends InPutPopJPanel implements FocusListener{

    private JPanel low,upper,cen,delta;
    private JTextField mLow,mUpper,mCen,mDelta;

    DecimalFormat df = new DecimalFormat("#.0");

    public InputVarRangePopJPanel(){
        super();
//        setLayout(new FlowLayout());
        setLayout(new GridLayout(3,2));
    }

    @Override
    public void initView() {
        super.initView();
        initLowBound();
        initUpperBound();
        initCenVal();
        initDeltaVal();
    }

    @Override
    public void initTitle() {
        JLabel title = new JLabel("范围属性");
        title.setSize(defaultWidth,defaultHeight);
        add(title);
        add(new JLabel());
    }

    private void initLowBound(){
        low = new JPanel();
        low.setLayout(new GridLayout(1,2));
        low.setSize(defaultWidth/2,defaultHeight);
        low.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        JTextField j1 = new JTextField("下限值");
        j1.setBackground(Color.decode(backColor));
        j1.setEditable(false);
        j1.setHorizontalAlignment(JTextField.LEFT);
        low.add(j1);
        mLow = new JTextField((String) model.getMap().get(InputNodeModel.LOW));
        mLow.setHorizontalAlignment(JTextField.LEFT);
        mLow.addFocusListener(this);
        low.add(mLow);
        add(low);
    }

    private void initUpperBound(){
        upper = new JPanel();
        upper.setLayout(new GridLayout(1,2));
        upper.setSize(defaultWidth/2,defaultHeight);
        upper.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        JTextField j1 = new JTextField("上限值");
        j1.setBackground(Color.decode(backColor));
        j1.setEditable(false);
        j1.setHorizontalAlignment(JTextField.LEFT);
        upper.add(j1);
        mUpper = new JTextField((String) model.getMap().get(InputNodeModel.UPPER));
        mUpper.setHorizontalAlignment(JTextField.LEFT);
        mUpper.addFocusListener(this);
        upper.add(mUpper);
        add(upper);
    }

    private void initCenVal(){
        cen = new JPanel();
        cen.setLayout(new GridLayout(1,2));
        cen.setSize(defaultWidth/2,defaultHeight);
        cen.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        JTextField j1 = new JTextField("中心值");
        j1.setBackground(Color.decode(backColor));
        j1.setEditable(false);
        j1.setHorizontalAlignment(JTextField.LEFT);
        cen.add(j1);
        mCen = new JTextField((String) model.getMap().get(InputNodeModel.CEN));
        mCen.setHorizontalAlignment(JTextField.LEFT);
        mCen.setEditable(false);
        cen.add(mCen);
        add(cen);
    }

    private void initDeltaVal(){
        delta = new JPanel();
        delta.setLayout(new GridLayout(1,2));
        delta.setSize(defaultWidth/2,defaultHeight);
        delta.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        JTextField j1 = new JTextField("Delta值");
        j1.setBackground(Color.decode(backColor));
        j1.setEditable(false);
        j1.setHorizontalAlignment(JTextField.LEFT);
        delta.add(j1);
        mDelta = new JTextField((String) model.getMap().get(InputNodeModel.DELTA));
        mDelta.setHorizontalAlignment(JTextField.LEFT);
        mDelta.setEditable(false);
        delta.add(mDelta);
        add(delta);
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        double low = Double.parseDouble(mLow.getText());
        double upper = Double.parseDouble(mUpper.getText());
        mCen.setText(df.format((low+upper)/2));
        if (low>upper)
            mDelta.setText("0.0");
        else
            mDelta.setText(df.format((upper-low)/2));
        save();
        model.update();
        mInputUpdateListener.update();
    }

    @Override
    public void save() {
        model.getMap().put(InputNodeModel.LOW,mLow.getText());
        model.getMap().put(InputNodeModel.UPPER,mUpper.getText());
        model.getMap().put(InputNodeModel.CEN,mCen.getText());
        model.getMap().put(InputNodeModel.DELTA,mDelta.getText());
    }

    @Override
    public void update() {

    }
}
