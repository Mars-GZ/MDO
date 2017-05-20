package djj.view;

import djj.core.BaseJPanel;
import djj.main.tab.workflow.model.InputNodeModel;

import javax.swing.*;
import java.awt.*;

/**
 * 输入变量属性
 * Created by mesmers on 2017/5/4.
 */
public class InputVarPopJPanel extends InPutPopJPanel {

    private JPanel name,description,format,varType;
    private JTextField jName,jDescription,jFormat;
    private JComboBox jVarType;

    public InputVarPopJPanel(){
        super();
//        setLayout(new FlowLayout());
        setLayout(new GridLayout(5,1));
    }

    @Override
    public void initView() {
        super.initView();
        initName();
        initDescription();
        initFormat();
        initVarType();
    }

    public void initTitle(){
        JLabel title = new JLabel("输入变量属性");
        title.setSize(defaultWidth,defaultHeight);
        add(title);
    }

    private void initName(){
        name = new JPanel();
        name.setLayout(new GridLayout(1,2));
        name.setSize(defaultWidth,defaultHeight);
        name.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        JTextField j1 = new JTextField("名称");
        j1.setBackground(Color.decode(backColor));
        j1.setEditable(false);
        j1.setHorizontalAlignment(JTextField.LEFT);
        name.add(j1);
        jName = new JTextField(model.getName());
        jName.setHorizontalAlignment(JTextField.LEFT);
        name.add(jName);
        add(name);
    }

    private void initDescription(){
        description = new JPanel();
        description.setLayout(new GridLayout(1,2));
        description.setSize(defaultWidth,defaultHeight);
        description.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        JTextField j1 = new JTextField("描述");
        j1.setBackground(Color.decode(backColor));
        j1.setEditable(false);
        j1.setHorizontalAlignment(JTextField.LEFT);
        description.add(j1);
        jDescription = new JTextField(model.getDescription());
        jDescription.setHorizontalAlignment(JTextField.LEFT);
        description.add(jDescription);
        add(description);
    }

    private void initFormat(){
        format = new JPanel();
        format.setLayout(new GridLayout(1,2));
        format.setSize(defaultWidth,defaultHeight);
        format.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        JTextField j1 = new JTextField("格式");
        j1.setEditable(false);
        j1.setBackground(Color.decode(backColor));
        j1.setHorizontalAlignment(JTextField.LEFT);
        format.add(j1);
        jFormat = new JTextField((String) model.getMap().get(InputNodeModel.FORMAT));
        jFormat.setHorizontalAlignment(JTextField.LEFT);
        format.add(jFormat);
        add(format);
    }

    private void initVarType(){
        varType = new JPanel();
        varType.setLayout(new GridLayout(1,2));
        varType.setSize(defaultWidth,defaultHeight);
        varType.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));

        JTextField j1 = new JTextField("变量类型");
        j1.setEditable(false);
        j1.setBackground(Color.decode(backColor));
        j1.setHorizontalAlignment(JTextField.LEFT);
        varType.add(j1);
        jVarType = new JComboBox(InputNodeModel.sVarType);
        int type = (int) model.getMap().get(InputNodeModel.VAR);
        jVarType.setSelectedIndex(type);
        varType.add(jVarType);
        add(varType);
    }

    public void save(){
        model.setName(jName.getText());
        model.setDescription(jDescription.getText());
        model.getMap().put(InputNodeModel.FORMAT,jFormat.getText());
        model.getMap().put(InputNodeModel.VAR,jVarType.getSelectedIndex());
    }

    @Override
    public void update() {

    }

}
