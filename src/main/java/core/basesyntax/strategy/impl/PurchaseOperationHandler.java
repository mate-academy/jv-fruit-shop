package core.basesyntax.strategy.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    private static final String LESS_QUANTITY_MESSAGE = "You have less product "
            + "than you are trying to buy! ";
    private static final String EXCEPTION_MESSAGE = "You don't have such fruits!";

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruitName = fruitTransaction.getFruit();
        Integer transactionQuantity = fruitTransaction.getQuantity();
        if (Storage.shopStorage.containsKey(fruitName)) {
            Integer availableQuantity = Storage.shopStorage.get(fruitName);
            if (availableQuantity < transactionQuantity) {
                throw new RuntimeException(LESS_QUANTITY_MESSAGE + fruitName);
            } else {
                Storage.shopStorage.put(fruitName, availableQuantity - transactionQuantity);
            }
        } else {
            throw new RuntimeException(EXCEPTION_MESSAGE);
        }
    }
}
