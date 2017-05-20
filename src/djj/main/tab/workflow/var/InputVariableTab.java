package djj.main.tab.workflow.var;

import djj.core.BaseJPanel;
import djj.core.BaseJTable;
import djj.main.tab.workflow.main.InputVarUpdatedListener;
import djj.main.tab.workflow.model.InputNodeModel;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by mesmers on 2017/4/16.
 */
public class InputVariableTab extends BaseJPanel implements InputVarChangedListener {

    private JTableModel mJTableModel;

    private InputVarUpdatedListener mInputVarUpdatedListener;

    public InputVarUpdatedListener getmInputVarUpdatedListener() {
        return mInputVarUpdatedListener;
    }

    public void setmInputVarUpdatedListener(InputVarUpdatedListener mInputVarUpdatedListener) {
        this.mInputVarUpdatedListener = mInputVarUpdatedListener;
    }

    public InputVariableTab() {
        Border titleBorder1 = BorderFactory.createTitledBorder("输入变量");
        setBorder(titleBorder1);
        setLayout(new GridLayout(1, 1));
    }

    @Override
    public void initView() {
        mJTableModel = new JTableModel();
        JTable jTable = new BaseJTable(mJTableModel);
        mJTableModel.addTableModelListener((e) -> {
            if (e.getColumn() < 0)
                return;
            InputNodeModel model = mJTableModel.getValue(e.getFirstRow());
            model.update();
            jTable.updateUI();
            mInputVarUpdatedListener.update(model.getId(), e.getColumn(), (String) model.getMap().get(e.getColumn()));
        });
        add(new JScrollPane(jTable));
    }

    @Override
    public void addInput(InputNodeModel model) {
        mJTableModel.insertRow(model);
    }

    @Override
    public void removeInput(InputNodeModel model) {
        mJTableModel.removeRow(model);
    }

    @Override
    public void updateInput(InputNodeModel model) {
        mJTableModel.updateRow(model);
    }

    private class JTableModel extends AbstractTableModel {

        private List<InputNodeModel> values = new ArrayList<>();

        private String[] title = new String[]{"ID", "名称", "变量类型", "值",
                "表达式", "分配", "缩放量", "下限值",
                "上限值", "中心值", "delta值", "Base",
                "步", "公差", "格式", "安排"};

        public JTableModel() {

        }

        public InputNodeModel getValue(int row) {
            return values.get(row);
        }

        public void insertRow(InputNodeModel model) {
            values.add(model);
            fireTableRowsInserted(values.size(), values.size());
        }

        public void removeRow(InputNodeModel model) {
            int size = getRowCount();
            for (int i = 0; i < size; i++) {
                InputNodeModel input = values.get(i);
                if (input == model) {
                    values.remove(input);
                    fireTableRowsDeleted(i, i);
                    break;
                }
            }
        }

        public void updateRow(InputNodeModel model) {
            updateUI();
        }

        @Override
        public int getRowCount() {
            return values.size();
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
            if (columnIndex == 2) {
                return InputNodeModel.sVarType[(int) values.get(rowIndex).getMap().get(InputNodeModel.VAR)];
            } else if (columnIndex == 15) {
                return InputNodeModel.sArrangeType[(int) values.get(rowIndex).getMap().get(InputNodeModel.ARRANGE)];
            } else if (columnIndex == 5) {
                return InputNodeModel.sDis[(int) values.get(rowIndex).getMap().get(InputNodeModel.DIS)];
            } else if (columnIndex > 1)
                return values.get(rowIndex).getMap().get(columnIndex);
            else if (columnIndex == 1)
                return values.get(rowIndex).getName();
            return values.get(rowIndex).getId() + "";
        }

        @Override
        public boolean isCellEditable(int row, int column) {
            if (column == 7 || column == 8)
                return true;
            return false;
        }

        @Override
        public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
            if (columnIndex == 1) {
                values.get(rowIndex).setName((String) aValue);
            } else if (columnIndex == 0) {
                values.get(rowIndex).setId((Integer) aValue);
            } else {
                values.get(rowIndex).getMap().put(columnIndex, aValue);
            }
            fireTableCellUpdated(rowIndex, columnIndex);
        }
    }

}
