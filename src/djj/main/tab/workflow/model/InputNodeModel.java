package djj.main.tab.workflow.model;

import djj.node.NodeConstant;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mesmers on 2017/5/4.
 */
public class InputNodeModel extends NodeModel {

    public static final int VAR = 2, VALUE = 3, EXPRESSION = 4, DIS = 5, SCALE = 6, LOW = 7, UPPER = 8,
            CEN = 9, DELTA = 10, BASE = 11, STEP = 12, TOL = 13, FORMAT = 14, ARRANGE = 15;

    public static final String[] sVarType = new String[]{"Variable", "Constant", "Expression"};

    public static final String[] sArrangeType = new String[]{"Order"};

    public static final String[] sDis = new String[]{"None"};

    DecimalFormat df = new DecimalFormat("#.0");

    private Map<Integer, Object> map = new HashMap<>();

    {
        map.put(VAR, 0);
        map.put(VALUE, "0.0");
        map.put(EXPRESSION, "");
        map.put(DIS, 0);
        map.put(SCALE, "0");
        map.put(LOW, "-1000.0");
        map.put(UPPER, "1000.0");
        map.put(CEN, "0.0");
        map.put(DELTA, "1000.0");
        map.put(BASE, "0");
        map.put(STEP, "0.0");
        map.put(TOL, "0.0");
        map.put(FORMAT, "0.0000E0");
        map.put(ARRANGE, 0);

        setK_type(NodeConstant.INPUT_VAR);
    }

    public Map<Integer, Object> getMap() {
        return map;
    }

    public void setMap(Map<Integer, Object> map) {
        this.map = map;
    }

    public void update() {
        double low = Double.parseDouble((String) map.get(LOW));
        double upper = Double.parseDouble((String) map.get(UPPER));
        map.put(CEN, df.format((low + upper) / 2));
        if (low > upper)
            map.put(DELTA, "0.0");
        else
            map.put(DELTA, df.format((upper - low) / 2));
        changeBase();
        changeStep();
    }

    public double changeBase(){
        double base = Double.parseDouble((String) map.get(BASE));
        double low = Double.parseDouble((String) map.get(LOW));
        double upper = Double.parseDouble((String) map.get(UPPER));
        double step=0.0;
        if (low>upper||base==0){
            map.put(BASE,"0.0");
            map.put(STEP,"0.0");
        }else {
            step = (upper-low)/(base-1);
            map.put(STEP,step);
        }
        return step;
    }

    public double changeStep(){
        double step = Double.parseDouble((String) map.get(STEP));
        double low = Double.parseDouble((String) map.get(LOW));
        double upper = Double.parseDouble((String) map.get(UPPER));
        double base=0.0;
        if (low>upper||step==0){
            map.put(BASE,"0.0");
            map.put(STEP,"0.0");
        }else {
            base = (upper-low)/step+1;
            map.put(BASE,base);
        }
        return base;
    }

    @Override
    public InputNodeModel clone() throws CloneNotSupportedException {
        InputNodeModel model = new InputNodeModel();
        model.setId(getId());
        model.setName(getName());
        model.setType(getType());
        model.setDescription(getDescription());
        model.setBackColor(getBackColor());
        model.setTextColor(getTextColor());
        model.setShowText(getShowText());
        model.setBorder(getBorder());
        model.setBorderWidth(getBorderWidth());
        model.setBorderHeight(getBorderHeight());
        model.setK_type(getK_type());
        Map<Integer, Object> map = new HashMap<>();
        Map<Integer,Object> re = getMap();
        map.put(VAR, re.get(VAR));
        map.put(VALUE, re.get(VALUE));
        map.put(EXPRESSION, re.get(EXPRESSION));
        map.put(DIS, re.get(DIS));
        map.put(SCALE, re.get(SCALE));
        map.put(LOW, re.get(LOW));
        map.put(UPPER, re.get(UPPER));
        map.put(CEN, re.get(CEN));
        map.put(DELTA, re.get(DELTA));
        map.put(BASE,re.get(BASE));
        map.put(STEP,re.get(STEP));
        map.put(TOL,re.get(TOL));
        map.put(FORMAT, re.get(FORMAT));
        map.put(ARRANGE, re.get(ARRANGE));
        model.setMap(map);
        return model;
    }

    public void save(InputNodeModel model){
        setId(model.getId());
        setName(model.getName());
        setDescription(getDescription());
        setBackColor(model.getBackColor());
        setTextColor(getTextColor());
        setShowText(getShowText());
        setBorder(getBorder());
        setBorderWidth(getBorderWidth());
        setBorderHeight(getBorderHeight());
        setK_type(getK_type());
        Map<Integer,Object> map = getMap();
        Map<Integer, Object> re = model.getMap();
        map.put(VAR, re.get(VAR));
        map.put(VALUE, re.get(VALUE));
        map.put(EXPRESSION, re.get(EXPRESSION));
        map.put(DIS, re.get(DIS));
        map.put(SCALE, re.get(SCALE));
        map.put(LOW, re.get(LOW));
        map.put(UPPER, re.get(UPPER));
        map.put(CEN, re.get(CEN));
        map.put(DELTA, re.get(DELTA));
        map.put(BASE,re.get(BASE));
        map.put(STEP,re.get(STEP));
        map.put(TOL,re.get(TOL));
        map.put(FORMAT, re.get(FORMAT));
        map.put(ARRANGE, re.get(ARRANGE));
    }
}
