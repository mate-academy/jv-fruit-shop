package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.storage.Storage;
import core.basesyntax.strategy.OperationHandler;

public class ReturnOperationHandlerImpl implements OperationHandler {
    @Override
    public void calculateData(FruitTransaction fruitTransaction) {
        if (!Storage.dataStorage.containsKey(fruitTransaction.getFruit())) {
            throw new RuntimeException("Operation failed, " + fruitTransaction.getFruit()
            + " is not exist!");
        }
        Storage.dataStorage.put(fruitTransaction.getFruit(),
                Storage.dataStorage.get(fruitTransaction.getFruit())
                        + fruitTransaction.getQuantity());
    }
}
