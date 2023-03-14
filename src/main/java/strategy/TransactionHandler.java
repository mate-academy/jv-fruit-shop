package strategy;

import model.FruitTransaction;

public interface TransactionHandler {
    void handle(FruitTransaction transaction);
}
