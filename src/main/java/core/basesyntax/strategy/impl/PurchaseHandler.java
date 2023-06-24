package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int quantityOfParchedFruits = fruitTransaction.getQuantity();
        int oldQuantity = Storage.fruitsStorage.get(fruitName);
        Storage.fruitsStorage.put(fruitName, oldQuantity - quantityOfParchedFruits);
    }
}
