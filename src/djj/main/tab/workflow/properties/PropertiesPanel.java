package djj.main.tab.workflow.properties;

import djj.core.BaseJPanel;
import djj.main.tab.workflow.model.NodeModel;
import djj.main.tab.workflow.main.PropertyDataChangedListener;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import java.awt.*;

/**
 * Created by mesmers on 2017/4/16.
 */
public class PropertiesPanel extends BaseJPanel implements PropertyChangedListener {

    private JTable mJtable;
    private JTableModel mTableModel;

    private PropertyDataChangedListener mPropertyDataChangedListener;

    public PropertyDataChangedListener getmPropertyDataChangedListener() {
        return mPropertyDataChangedListener;
    }

    public void setmPropertyDataChangedListener(PropertyDataChangedListener mPropertyDataChangedListener) {
        this.mPropertyDataChangedListener = mPropertyDataChangedListener;
    }

    public PropertiesPanel() {
        Border titleBorder1 = BorderFactory.createTitledBorder("属性");
        setBorder(titleBorder1);
        setLayout(new GridLayout(1, 1));
    }

    @Override
    public void initView() {
        mTableModel = new JTableModel();
        mJtable = new JTable(mTableModel);
        mTableModel.addTableModelListener((e) -> {
            mPropertyDataChangedListener.updateNode(mTableModel.getProperties()[e.getFirstRow()],mTableModel.getValues()[e.getFirstRow()],Integer.parseInt(mTableModel.getValues()[0]));
        });
        add(new JScrollPane(mJtable));
    }

    @Override
    public void change(NodeModel model) {
        mTableModel.setValues(new String[]{model.getId() + "", model.getName(), model.getBackColor(),
                model.getTextColor(), model.getShowText(), model.getBorder(),
                model.getBorderWidth(), model.getBorderHeight()});
        mJtable.updateUI();
    }

    @Override
    public void update() {
        mJtable.updateUI();
    }

    @Override
    public void reset() {
        mTableModel.setValues(new String[]{"","","","",
                                           "","","",""});
        mJtable.updateUI();
    }

    private class JTableModel extends AbstractTableModel {

        private String[] properties = new String[]{"ID", "名称", "背景色",
                "文字颜色", "显示文字",
                "边框大小", "边框宽度",
                "边框高度"};

        private String[] values = new String[]{"", "", "",
                "", "", "", "",
                ""};

        private String[] title = new String[]{"属性", "属性值"};

        public void setValues(String[] values) {
            this.values = values;
        }

        public String[] getValues() {
            return values;
        }

        public String[] getProperties() {
            return properties;
        }

        public void setProperties(String[] properties) {
            this.properties = properties;
        }

        @Override
        public int getRowCount() {
            return properties.length;
        }

        @Override
        public int getColumnCount() {
            return title.length;
        }

        @Override
        public String getColumnName(int column) {
            return title[column];
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0)
                return properties[rowIndex];
            return values[rowIndex];
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (row>4||row==0)
                return false;
            return true;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            if (columnIndex == 1) {
                values[rowIndex] = (String) aValue;
                fireTableCellUpdated(rowIndex, columnIndex);
            }
        }
    }
}
