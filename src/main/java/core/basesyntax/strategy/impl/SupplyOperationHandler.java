package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandler implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        Integer transactionQuantity = fruitTransaction.getQuantity();
        if (Storage.shopStorage.containsKey(fruitName)) {
            Integer currentQuantity = Storage.shopStorage.get(fruitName);
            Storage.shopStorage.put(fruitName, currentQuantity + transactionQuantity);
        } else {
            Storage.shopStorage.put(fruitName, transactionQuantity);
        }
    }
}
