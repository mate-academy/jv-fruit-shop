package impl.operation;

import impl.operation.operations.OperationHandler;
import model.Operation;

public interface OperationStrategy {
    OperationHandler getOperationHandler(Operation operation);
}
