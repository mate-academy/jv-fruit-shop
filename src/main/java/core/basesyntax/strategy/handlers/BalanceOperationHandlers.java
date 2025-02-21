package core.basesyntax.strategy.handlers;

import core.basesyntax.FruitTransaction;
import core.basesyntax.db.FruitStorage;

public class BalanceOperationHandlers implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction) {
        String fruit = transaction.getFruit();
        Integer quantity = transaction.getQuantity();
        FruitStorage.storage.put(fruit, quantity);
    }
}
