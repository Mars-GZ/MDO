package djj.core;

import javax.swing.*;
import javax.swing.table.TableModel;

/**
 * Created by mesmers on 2017/4/23.
 */
public class BaseJTable extends JTable {

    public BaseJTable(){
        super();
    }

    public BaseJTable(final Object[][] rowData, final Object[] columnNames){
        super(rowData,columnNames);
    }

    public BaseJTable(TableModel dm){
        super(dm);
    }
}
