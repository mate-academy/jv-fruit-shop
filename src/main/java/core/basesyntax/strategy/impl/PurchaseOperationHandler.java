package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        Integer valueBeforePurchase = Storage.FRUITS.get(fruitTransaction.getFruit());
        Integer valueAfterPurchase = valueBeforePurchase - fruitTransaction.getQuantity();
        Storage.FRUITS.put(fruitTransaction.getFruit(), valueAfterPurchase);
    }
}
