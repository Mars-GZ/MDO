package djj.main.tab.workflow.main;

import djj.core.BaseJPanel;
import djj.core.Constant;
import djj.util.FileReadUtil;

import javax.swing.*;
import java.awt.*;
import java.io.*;

/**
 * 下方总工具
 * Created by mesmers on 2017/4/18.
 */
public class ToolJPanel extends BaseJPanel {

    private String[] imgRes;
    private String[] res;
    private String[] detailRes;
    private ToolUpdateListener toolListener;
    private ButtonGroup group;

    public ToolUpdateListener getToolListener() {
        return toolListener;
    }

    public void setToolListener(ToolUpdateListener toolListener) {
        this.toolListener = toolListener;
    }

    {
        File file = new File(Constant.ICON_PATH + "label");
        String[] files = file.list();
        imgRes = new String[files.length];
        detailRes = new String[files.length];
        File fres = new File(Constant.DESCRIPTION + "labels");
        res = FileReadUtil.getFileContent(fres).split(",");
        for (int i = 0; i < imgRes.length; i++) {
            imgRes[i] = file.getPath() + "/" + files[i];
            detailRes[i] = files[i].substring(0, files[i].indexOf("node")+4);
        }
    }

    public ToolJPanel() {
        setLayout(new BorderLayout());
    }

    @Override
    public void initView() {
        add(createImageJPanel(), BorderLayout.SOUTH);
    }

    private JPanel createImageJPanel() {
        JPanel j = new JPanel();
        j.setLayout(new FlowLayout());
        group = new ButtonGroup();
        for (int i = 0; i < imgRes.length; i++) {
            ImageIcon imageIcon = new ImageIcon(imgRes[i]);
            JButton btn = new JButton(imageIcon);
            btn.setBounds(i * 30, 0, 30, 30);
            btn.setToolTipText(res[i]);
            String m = detailRes[i];
            btn.addActionListener(e -> {
                toolListener.sendTool(m);
            });
            group.add(btn);
            j.add(btn);
        }
        return j;
    }
}
