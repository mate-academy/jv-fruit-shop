package mate.academy.strategy;

import mate.academy.model.Fruit;
import mate.academy.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Fruit.Operation operation);
}
