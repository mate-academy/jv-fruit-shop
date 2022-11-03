package fruitshop.strategy.operation;

import fruitshop.model.Operation;

public interface OperationStrategy {
    OperationHandler getHandler(Operation operation);
}
