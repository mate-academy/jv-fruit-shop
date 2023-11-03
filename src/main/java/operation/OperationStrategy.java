package operation;

import model.Operation;

public interface OperationStrategy {
    OperationHandler get(Operation operationType);
}
