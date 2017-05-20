package djj.main.tab.workflow.properties;

import djj.core.BaseJTable;

import javax.swing.table.TableModel;

/**
 * Created by mesmers on 2017/5/3.
 */
public class PropertyJTable extends BaseJTable{

    public  PropertyJTable(){
        super();
    }

    public PropertyJTable(Object[][] rowData,Object[] columnNames){
        super(rowData,columnNames);
    }

    public PropertyJTable(TableModel dm){
        super(dm);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        if (row>4||row==0)
            return false;
        return true;
    }
}
