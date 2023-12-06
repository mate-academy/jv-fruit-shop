package core.basesyntax.strategy.handler;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void process(FruitTransaction transaction, Storage fruitInventory) {
        fruitInventory.merge(transaction.fruit(), -transaction.quantity(), Integer::sum);
    }
}
