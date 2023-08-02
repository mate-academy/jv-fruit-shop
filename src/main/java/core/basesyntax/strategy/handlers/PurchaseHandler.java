package core.basesyntax.strategy.handlers;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        int newAmount = Storage.storage.get(fruitTransaction.getFruit()) - fruitTransaction.getQuantity();
        if (newAmount < 0) {
            throw new RuntimeException("Can't do purchase, because amount will be less than 0");
        }
        Storage.storage.put(fruitTransaction.getFruit(), newAmount);
    }
}
