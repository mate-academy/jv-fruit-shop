package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.models.FruitTransaction;
import core.basesyntax.service.OperationHandler;

public class BalanceImpl implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        if (Storage.storage.containsKey(fruit)) {
            Storage.storage.put(fruit, Storage.storage.get(fruit) + fruitTransaction.getQuantity());
        } else {
            Storage.storage.put(fruit, fruitTransaction.getQuantity());
        }
    }
}
