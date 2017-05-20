package djj.view;

import djj.core.BaseJPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by mesmers on 2017/5/6.
 */
public class SelectPopJPanel extends InPutPopJPanel{

    private JPanel ok;
    private JButton jOk, jCancel;
    private MyListener myListener;
    private SelectListener mSelectListener;

    public SelectListener getmSelectListener() {
        return mSelectListener;
    }

    public void setmSelectListener(SelectListener mSelectListener) {
        this.mSelectListener = mSelectListener;
    }

    public SelectPopJPanel() {
        super();
        setLayout(new FlowLayout(FlowLayout.CENTER));
//        setLayout(new GridLayout(1, 1));
    }

    @Override
    public void initView() {
        super.initView();
        initOK();
    }

    @Override
    public void initTitle() {

    }

    @Override
    public void save() {

    }

    @Override
    public void update() {

    }

    private void initOK() {
        myListener = new MyListener();

        ok = new JPanel();
        ok.setLayout(new FlowLayout(FlowLayout.CENTER));
        ok.setSize(defaultWidth, defaultHeight);
        ok.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));

        jOk = new JButton("保存");
        jOk.setBorder(new EmptyBorder(0,14,0,14));
        jOk.addMouseListener(myListener);
        jOk.setSize(140,40);
        jCancel = new JButton("取消");
        jCancel.setBorder(new EmptyBorder(0,14,0,14));
        jCancel.addMouseListener(myListener);
        jCancel.setSize(140,40);
        ok.add(jOk);
        ok.add(jCancel);
        add(ok);
    }

    public void ok() {
        mSelectListener.ok();
    }


    public void cancel() {
      mSelectListener.cancel();
    }

    private class MyListener extends MouseAdapter{

        @Override
        public void mouseReleased(MouseEvent e) {
            if (e.getSource()==jOk){
                ok();
            }else if (e.getSource()==jCancel){
                cancel();
            }
        }
    }
}
