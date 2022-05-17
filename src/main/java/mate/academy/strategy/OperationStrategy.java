package mate.academy.strategy;

import mate.academy.model.FruitTransaction;
import mate.academy.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler process(FruitTransaction.Operation operation);
}
