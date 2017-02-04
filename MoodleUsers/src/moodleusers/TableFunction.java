package moodleusers;
import javax.swing.JTable;

public abstract class TableFunction {

    public final TableModelExp model;
    public final JTable table;

    public TableFunction(JTable table) {
        this.table = table;
        this.model =(TableModelExp) table.getModel();
    }

    public abstract void excute();
}
