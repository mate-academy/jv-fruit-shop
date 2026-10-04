package core.basesyntax.strategy;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class BalanceOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction transaction, Storage storage) {
        String fruit = transaction.getFruit();
        int quantity = transaction.getQuantity();
        storage.put(fruit, quantity);
    }
}
