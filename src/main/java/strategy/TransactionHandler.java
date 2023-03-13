package strategy;

import model.FruitTransaction;

public interface TransactionHandler {
    void handler(FruitTransaction transaction);
}
