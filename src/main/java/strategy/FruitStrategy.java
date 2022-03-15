package strategy;

import model.Fruit;
import operation.Operation;

public interface FruitStrategy {
    Operation get(Fruit.Operation operation);
}
