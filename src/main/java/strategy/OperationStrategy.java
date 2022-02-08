package strategy;

import model.Fruit;
import service.operation.Calculator;

public interface OperationStrategy {
    Calculator get(Fruit.OperationType type);
}
