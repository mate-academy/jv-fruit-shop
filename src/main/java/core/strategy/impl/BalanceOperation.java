package core.strategy.impl;

import core.db.Storage;
import core.strategy.FruitTransaction;
import core.strategy.OperationHandler;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Storage storage) {
        // Просто встановлюємо початкове значення
        storage.setFruit(transaction.getFruit(), transaction.getQuantity());
    }
}
