package djj.main.tab.workflow.main;

import djj.core.BaseJPanel;
import djj.core.Constant;
import djj.util.FileReadUtil;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * 上方详细工具
 * Created by mesmers on 2017/4/18.
 */
public class ToolDetailJPanel extends BaseJPanel implements ToolUpdateListener, PaintCallBack {

    private String[] imgRes;
    private String[] res;
    private JPanel contentPanel;
    private Map<String, JRadioButton[]> btnMap;
    private String currentPath = "";
    private JRadioButton[] mCurrentRbtn;
    private JRadioButton mSelectBtn;
    private ChangeMouseListener mouseListener;

    public ChangeMouseListener getMouseListener() {
        return mouseListener;
    }

    public void setMouseListener(ChangeMouseListener mouseListener) {
        this.mouseListener = mouseListener;
    }

    public ToolDetailJPanel() {
        setLayout(new BorderLayout());
    }

    @Override
    public void initView() {
        contentPanel = new JPanel();
        contentPanel.setLayout(new FlowLayout());
        contentPanel.setBounds(0, 0, getWidth(), getHeight());
        add(contentPanel, BorderLayout.SOUTH);

        btnMap = new HashMap<>();
    }

    /**
     * 得到路径
     *
     * @param path
     */
    @Override
    public void sendTool(String path) {
        synchronized (this) {
            if (btnMap.get(path) == null) {
                getRes(path);
                addItem(path);
            }
            if (!currentPath.equals(path)) {
                if (mSelectBtn != null)
                    mSelectBtn.setSelected(true);
                mouseListener.clearState();
                drawItem(path);
                contentPanel.revalidate();
                repaint();
                currentPath = path;
            }
        }
    }

    public void getRes(String path) {
        File file = new File(Constant.ICON_PATH + path);
        File fres = new File(Constant.DESCRIPTION + path);
        res = FileReadUtil.getFileContent(fres).split(",");
        String[] files = file.list();
        imgRes = new String[files.length];
        for (int i = 0; i < imgRes.length; i++) {
            imgRes[i] = file.getPath() + "/" + files[i];
        }
    }

    private void addItem(String path) {
        JRadioButton[] btns = new JRadioButton[imgRes.length];
        for (int i = 0; i < imgRes.length; i++) {
            ImageIcon imageIcon = new ImageIcon(imgRes[i]);
            JRadioButton btn = new JRadioButton(imageIcon);
            btn.setSelected(true);
            btn.addActionListener(e -> {
                if (mSelectBtn!=null&&mSelectBtn != btn) {
                    mSelectBtn.setSelected(true);
                    mSelectBtn.setBackground(Color.WHITE);
                }
                mSelectBtn = btn;
                if (btn.isSelected()) {
                    mouseListener.clearState();
                    btn.setBackground(Color.WHITE);
                } else {
                    mouseListener.addTool(btn);
                    mSelectBtn = btn;
                    btn.setBackground(Color.GRAY);
                }
            });
            btn.setName(res[i]);
            btn.setBounds(i * 20, 0, 20, 20);
            btn.setToolTipText(res[i]);
            btns[i] = btn;
        }
        btnMap.put(path, btns);
    }

    private void drawItem(String path) {
        contentPanel.removeAll();
        mCurrentRbtn = btnMap.get(path);

        for (int i = 0; i < mCurrentRbtn.length; i++) {
            JRadioButton btn = mCurrentRbtn[i];
            contentPanel.add(btn);
        }
    }

    @Override
    public void hasPaint() {
        if (mSelectBtn!=null) {
            mSelectBtn.setSelected(true);
            mSelectBtn.setBackground(Color.WHITE);
        }
    }
}
