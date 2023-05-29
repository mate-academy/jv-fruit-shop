package service;

import model.Fruit;
import strategy.OperationsStrategy;

public interface FruitStrategy {
    OperationsStrategy get(Fruit.Operation operation);
}
