package strategy;

import model.Fruit;

public interface FruitStrategy {
    OperationsStrategy get(Fruit.Operation operation);
}
