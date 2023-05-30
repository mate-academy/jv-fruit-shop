package strategy;

import model.OperationType;
import service.operation.handlers.OperationHandler;

public interface DalyOperationStrategy {
    OperationHandler getOperation(OperationType operationType);
}
