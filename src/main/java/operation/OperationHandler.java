package operation;

import model.Record;

public interface OperationHandler {
    void apply(Record record);
}
