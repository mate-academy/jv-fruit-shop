package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        Integer transactionQuantity = fruitTransaction.getQuantity();
        if (!Storage.SHOPSTORAGE.containsKey(fruitName)) {
            Storage.SHOPSTORAGE.put(fruitName, fruitTransaction.getQuantity());
        } else {
            Integer currentQuantity = Storage.SHOPSTORAGE.get(fruitName);
            Storage.SHOPSTORAGE.put(fruitName, currentQuantity + transactionQuantity);
        }
    }
}
