package strategy;

import model.OperationType;

public interface OperationStrategy {
    OperationHandler getOperation(OperationType operationType);
}
