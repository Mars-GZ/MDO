package djj.view;

import djj.main.tab.workflow.model.InputNodeModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by mesmers on 2017/5/5.
 */
public class InputVarBasePopJPanel extends InPutPopJPanel implements FocusListener {

    private JPanel base, step, tol, arrange;
    private JTextField jBase, jStep, jTol;
    private JComboBox jArrange;

    public InputVarBasePopJPanel() {
        super();
//        setLayout(new FlowLayout());
        setLayout(new GridLayout(5, 1));
    }

    @Override
    public void initView() {
        super.initView();
        initBase();
        initStep();
        initTol();
        initArrange();
    }

    @Override
    public void initTitle() {
        JLabel title = new JLabel("Base属性");
        title.setSize(defaultWidth, defaultHeight);
        add(title);
    }

    private void initBase() {
        base = new JPanel();
        base.setLayout(new GridLayout(1, 2));
        base.setSize(defaultWidth, defaultHeight);
        base.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        JTextField j1 = new JTextField("BASE");
        j1.setBackground(Color.decode(backColor));
        j1.setEditable(false);
        j1.setHorizontalAlignment(JTextField.LEFT);
        base.add(j1);
        jBase = new JTextField(model.getMap().get(InputNodeModel.BASE) + "");
        jBase.setHorizontalAlignment(JTextField.LEFT);
        jBase.addFocusListener(this);
        base.add(jBase);
        add(base);
    }

    private void initStep() {
        step = new JPanel();
        step.setLayout(new GridLayout(1, 2));
        step.setSize(defaultWidth, defaultHeight);
        step.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        JTextField j1 = new JTextField("STEP");
        j1.setBackground(Color.decode(backColor));
        j1.setEditable(false);
        j1.setHorizontalAlignment(JTextField.LEFT);
        step.add(j1);
        jStep = new JTextField(model.getMap().get(InputNodeModel.STEP) + "");
        jStep.setHorizontalAlignment(JTextField.LEFT);
        jStep.addFocusListener(this);
        step.add(jStep);
        add(step);
    }

    private void initTol() {
        tol = new JPanel();
        tol.setLayout(new GridLayout(1, 2));
        tol.setSize(defaultWidth, defaultHeight);
        tol.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        JTextField j1 = new JTextField("Tolerance");
        j1.setBackground(Color.decode(backColor));
        j1.setEditable(false);
        j1.setHorizontalAlignment(JTextField.LEFT);
        tol.add(j1);
        jTol = new JTextField(model.getMap().get(InputNodeModel.TOL) + "");
        jTol.setHorizontalAlignment(JTextField.LEFT);
        tol.add(jTol);
        add(tol);
    }

    private void initArrange() {
        arrange = new JPanel();
        arrange.setLayout(new GridLayout(1, 2));
        arrange.setSize(defaultWidth, defaultHeight);
        arrange.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        JTextField j1 = new JTextField("Arrangement");
        j1.setEditable(false);
        j1.setBackground(Color.decode(backColor));
        j1.setHorizontalAlignment(JTextField.LEFT);
        arrange.add(j1);
        jArrange = new JComboBox(InputNodeModel.sArrangeType);
        int type = (int) model.getMap().get(InputNodeModel.ARRANGE);
        jArrange.setSelectedIndex(type);
        arrange.add(jArrange);
        add(arrange);
    }

    @Override
    public void save() {
        model.getMap().put(InputNodeModel.BASE, jBase.getText());
        model.getMap().put(InputNodeModel.STEP, jStep.getText());
        model.getMap().put(InputNodeModel.TOL, jTol.getText());
        model.getMap().put(InputNodeModel.ARRANGE, jArrange.getSelectedIndex());
    }

    @Override
    public void update() {
        jBase.setText((String) model.getMap().get(InputNodeModel.BASE));
        jStep.setText((String) model.getMap().get(InputNodeModel.STEP));
    }

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {
        Object o = e.getSource();
        if (o == jBase) {
            model.getMap().put(InputNodeModel.BASE, jBase.getText());
            double step = model.changeBase();
            jStep.setText(String.valueOf(step));
        } else if (o == jStep) {
            model.getMap().put(InputNodeModel.STEP, jStep.getText());
            double base = model.changeStep();
            jBase.setText(String.valueOf(base));
        }
    }
}
