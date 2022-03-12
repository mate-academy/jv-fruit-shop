package strategy;

import model.Fruit;
import operation.OperationHandler;

public interface FruitStrategy {
    OperationHandler get(Fruit.Operation operation);
}
