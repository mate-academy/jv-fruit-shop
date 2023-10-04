package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandlerImpl implements OperationHandler {
    private static final int INVALID_QUANTITY = 0;

    @Override
    public void handle(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < INVALID_QUANTITY) {
            throw new RuntimeException("Quantity can`t be less then " + INVALID_QUANTITY);
        }
        if (!Storage.dataStorage.containsKey(fruitTransaction.getFruit())) {
            throw new RuntimeException("Operation failed, " + fruitTransaction.getFruit()
            + " is not exist!");
        }
        Storage.dataStorage.put(fruitTransaction.getFruit(),
                Storage.dataStorage.get(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity());
    }
}
