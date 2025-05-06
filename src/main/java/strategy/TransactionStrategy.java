package strategy;

import model.FruitTransaction;

public interface TransactionStrategy {
    void apply(FruitTransaction fruit, FruitTransaction transaction);
}
