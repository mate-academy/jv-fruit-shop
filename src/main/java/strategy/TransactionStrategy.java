package strategy;

import model.FruitTransaction;

public interface TransactionStrategy {
    FruitTransaction.Operation get(String data);
}
