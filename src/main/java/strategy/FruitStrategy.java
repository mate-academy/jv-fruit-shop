package strategy;

import model.FruitTransaction;
import operation.Operation;

public interface FruitStrategy {
    Operation proceed(FruitTransaction fruitTransaction);
}
