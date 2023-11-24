package strategy;

import model.FruitStorage;
import model.FruitTransaction;

public interface TransactionStrategy {
    void apply(FruitStorage fruitStorage, FruitTransaction transaction);
}
