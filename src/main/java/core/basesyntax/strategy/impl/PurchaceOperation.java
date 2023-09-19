package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationService;

public class PurchaceOperation implements OperationService {
    @Override
    public void doOperation(FruitTransaction fruitTransaction) {
        int balance = Storage.getStorage().get(fruitTransaction.getFruit());
        int purchase = balance - fruitTransaction.getQuantity();
        if (purchase < 0) {
            throw new RuntimeException("Not enough quantity in shop");
        }
        Storage.getStorage().put(fruitTransaction.getFruit(),purchase);
    }
}
