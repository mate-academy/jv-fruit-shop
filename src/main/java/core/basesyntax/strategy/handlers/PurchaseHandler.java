package core.basesyntax.strategy.handlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        int newAmount = Storage.storage.get(fruitTransaction.getFruit())
                - fruitTransaction.getQuantity();
        if (newAmount < 0) {
            throw new RuntimeException(String
                    .format("Can't do purchase, because of shortage of %s. You can buy only %d",
                            fruitTransaction.getFruit(),
                            fruitTransaction.getQuantity()));
        }
        Storage.storage.put(fruitTransaction.getFruit(), newAmount);
    }
}
