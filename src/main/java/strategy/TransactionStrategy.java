package strategy;

import db.FruitStorage;
import model.FruitTransaction;

public interface TransactionStrategy {
    void apply(FruitStorage fruitStorage, FruitTransaction transaction);
}
