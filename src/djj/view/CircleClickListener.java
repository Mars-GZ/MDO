package djj.view;

/**
 * Created by mesmers on 2017/5/18.
 */
public interface CircleClickListener {

    void click(int type,CircleJPanel circleJPanel);

    void cancel();

    void draw(CircleJPanel circleJPanel);

}
