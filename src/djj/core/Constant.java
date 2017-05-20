package djj.core;

import java.util.HashMap;

/**
 * Created by mesmers on 2017/4/18.
 */
public class Constant {

    public static final String ICON_PATH="icon/";
    public static final String DESCRIPTION = "icon/description/";
    public static final String SICON = "icon/node_icon/";


    public static final HashMap<String,Integer> map = new HashMap<>();

    static {
        map.put("输入变量",0);
        map.put("逻辑判断点",1);
        map.put("输出变量",2);
    }

}
