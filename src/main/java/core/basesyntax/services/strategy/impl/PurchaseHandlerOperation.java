package core.basesyntax.services.strategy.impl;

import core.basesyntax.db.DataStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.strategy.OperationHandler;

public class PurchaseHandlerOperation implements OperationHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int transactionQuantity = fruitTransaction.getQuantity();
        int storageQuantity = DataStorage.fruitsStorageMap.get(fruit);
        DataStorage.fruitsStorageMap.put(fruit, storageQuantity - transactionQuantity);
    }
}
