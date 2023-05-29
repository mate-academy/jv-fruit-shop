package strategy;

import model.OperationType;
import service.operation.handlers.OperationHandler;

//Strategy Interface.
public interface DalyOperationStrategy {
    OperationHandler getOperation(OperationType operationType);
}
