package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class BalanceOperationHandler implements OperationHandler {
    @Override
    public void process(FruitTransaction transaction, Storage fruitInventory) {
        fruitInventory.put(transaction.fruit(), transaction.quantity());
    }
}
