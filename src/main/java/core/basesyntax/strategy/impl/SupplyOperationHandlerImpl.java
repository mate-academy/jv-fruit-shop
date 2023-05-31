package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

public class SupplyOperationHandlerImpl implements OperationHandler {
    private static final int INVALID_QUANTITY = 0;

    @Override
    public void calculateData(FruitTransaction fruitTransaction) {
        if (fruitTransaction.getQuantity() < INVALID_QUANTITY) {
            throw new RuntimeException("Quantity can`t be less then " + INVALID_QUANTITY);
        }
        if (!Storage.dataStorage.containsKey(fruitTransaction.getFruit())) {
            Storage.dataStorage.put(fruitTransaction.getFruit(), fruitTransaction.getQuantity());
        } else {
            Storage.dataStorage.put(fruitTransaction.getFruit(),
                    Storage.dataStorage.get(fruitTransaction.getFruit())
                            + fruitTransaction.getQuantity());
        }
    }
}
