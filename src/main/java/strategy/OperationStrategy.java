package strategy;

import model.Operation;
import strategy.handler.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Operation operation);
}
