package operation;

import model.Record;

public interface OperationStrategy {
    OperationHandler operate(String operationType);
}
