package strategy;

import model.Operation;

public interface OperationStrategy {
    OperationHandler getOperationHandler(Operation operation);
}
