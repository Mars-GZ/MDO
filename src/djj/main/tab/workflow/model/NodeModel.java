package djj.main.tab.workflow.model;

/**
 * Created by mesmers on 2017/4/16.
 */
public class NodeModel {

    private String name;
    private String type;
    private int id;

    private String description="";

    private String backColor="#FFFFFF";
    private String textColor="#000000";
    private String showText="true";
    private String borderWidth="1";
    private String borderHeight="1";
    private String border="1";

    private int k_type;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getK_type() {
        return k_type;
    }

    public void setK_type(int k_type) {
        this.k_type = k_type;
    }

    public String getBackColor() {
        return backColor;
    }

    public void setBackColor(String backColor) {
        this.backColor = backColor;
    }

    public String getTextColor() {
        return textColor;
    }

    public void setTextColor(String textColor) {
        this.textColor = textColor;
    }

    public String getShowText() {
        return showText;
    }

    public void setShowText(String showText) {
        this.showText = showText;
    }

    public String getBorderWidth() {
        return borderWidth;
    }

    public void setBorderWidth(String borderWidth) {
        this.borderWidth = borderWidth;
    }

    public String getBorderHeight() {
        return borderHeight;
    }

    public void setBorderHeight(String borderHeight) {
        this.borderHeight = borderHeight;
    }

    public String getBorder() {
        return border;
    }

    public void setBorder(String border) {
        this.border = border;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
