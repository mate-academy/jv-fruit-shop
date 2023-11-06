package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private static final String STORAGE_FRUIT_EXCEPTION_MESSAGE = "In your storage,"
            + " you don`t have any: ";

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        Integer transactionQuantity = fruitTransaction.getQuantity();
        if (Storage.SHOPSTORAGE.containsKey(fruitName)) {
            Integer availableQuantity = Storage.SHOPSTORAGE.get(fruitName);
            Storage.SHOPSTORAGE.put(fruitName, availableQuantity - transactionQuantity);
        } else {
            throw new RuntimeException(STORAGE_FRUIT_EXCEPTION_MESSAGE + fruitName);
        }
    }
}
