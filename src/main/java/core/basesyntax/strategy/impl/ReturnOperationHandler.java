package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        int transactionQuantity = fruitTransaction.getQuantity();
        int initialQuantity = Storage.STORAGE.get(fruitName);
        Storage.STORAGE.put(
                fruitTransaction.getFruit(), initialQuantity + transactionQuantity);
    }
}
