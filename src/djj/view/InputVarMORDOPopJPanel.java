package djj.view;

import djj.main.tab.workflow.model.InputNodeModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

/**
 * Created by mesmers on 2017/5/6.
 */
public class InputVarMORDOPopJPanel extends InPutPopJPanel implements FocusListener {

    private JPanel distribution;

    private JComboBox jDistribution;

    @Override
    public void focusGained(FocusEvent e) {

    }

    @Override
    public void focusLost(FocusEvent e) {

    }

    public InputVarMORDOPopJPanel(){
        super();
//        setLayout(new FlowLayout());
        setLayout(new GridLayout(2,1));
    }

    @Override
    public void initView() {
        super.initView();
        initDistribution();
    }

    @Override
    public void initTitle() {
        JLabel title = new JLabel("MDRDO属性");
        title.setSize(defaultWidth, defaultHeight);
        add(title);
    }

    private void initDistribution(){
        distribution = new JPanel();
        distribution.setLayout(new GridLayout(1, 2));
        distribution.setSize(defaultWidth, defaultHeight);
        distribution.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        JTextField j1 = new JTextField("Distribution");
        j1.setEditable(false);
        j1.setBackground(Color.decode(backColor));
        j1.setHorizontalAlignment(JTextField.LEFT);
        distribution.add(j1);
        jDistribution = new JComboBox(InputNodeModel.sDis);
        int type = (int) model.getMap().get(InputNodeModel.DIS);
        jDistribution.setSelectedIndex(type);
        distribution.add(jDistribution);
        add(distribution);
    }

    @Override
    public void save() {

    }

    @Override
    public void update() {

    }
}
