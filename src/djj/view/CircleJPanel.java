package djj.view;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Created by mesmers on 2017/5/18.
 */
public class CircleJPanel extends JPanel {

    private Color color;

    private CircleClickListener mCircleClickListener;

    public static final int IN = 0, OUT = 1;

    private int type;

    private MyListener myListener;

    private boolean isClicked;

    private boolean isNexted;

    private boolean isStart = false;

    public boolean isStart() {
        return isStart;
    }

    public void setStart(boolean start) {
        isStart = start;
    }

    public CircleClickListener getmCircleClickListener() {
        return mCircleClickListener;
    }

    public void setmCircleClickListener(CircleClickListener mCircleClickListener) {
        this.mCircleClickListener = mCircleClickListener;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public CircleJPanel(int type) {
        super();
        this.type = type;
        color = Color.BLACK;
        myListener = new MyListener();
        addMouseListener(myListener);
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.setColor(color);
        g.drawOval(0, 0, 9, 9);
    }

    public void setPressed(boolean pressed) {
        if (pressed) {
            color = Color.ORANGE;
            isNexted = true;
        }
        else {
            color = Color.BLACK;
            isNexted = false;
        }
        updateUI();
    }

    public void refresh(){
        color = Color.BLACK;
        isNexted = false;
        isClicked = false;
        repaint();
    }

    private class MyListener extends MouseAdapter {

        @Override
        public void mouseReleased(MouseEvent e) {
            if (isNexted){
                isNexted = false;
                mCircleClickListener.draw(CircleJPanel.this);
                return;
            }
            if (!isClicked) {
                isStart = true;
                mCircleClickListener.click(type,CircleJPanel.this);
                color = Color.ORANGE;
            }else{
                mCircleClickListener.cancel();
                color = Color.BLACK;
            }
            isClicked = !isClicked;
            repaint();
        }

    }
}
