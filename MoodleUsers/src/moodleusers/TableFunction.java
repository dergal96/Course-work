package moodleusers;

public abstract class TableFunction {
    public TableModelExp model;

    public TableFunction(TableModelExp model) {
        this.model = model;
    }

    public abstract void excute();
}
