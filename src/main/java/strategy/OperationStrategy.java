package strategy;

import model.Operation;

public interface OperationStrategy {
    OperationHandler get(Operation operation);
}
