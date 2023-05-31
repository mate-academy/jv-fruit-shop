package core.basesyntax.strategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.Storage;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void toStorage(FruitTransaction transaction) {
        Storage.fruitInventory
                .put(transaction.getFruit(), Storage.fruitInventory.get(transaction.getFruit())
                        - transaction.getQuantity());
    }
}
