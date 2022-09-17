package strategy;

import model.Fruit;
import strategy.operationhandlers.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Fruit.Operation operation);
}
