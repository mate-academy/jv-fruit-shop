package core.basesyntax.services.strategy.impl;

import core.basesyntax.db.DataStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.strategy.OperationHandler;

public class ReturnHandlerOperation implements OperationHandler {
    @Override
    public void handle(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantityFruits = fruitTransaction.getQuantity();
        int previousQuantity = DataStorage.fruitsStorageMap.get(fruit);
        DataStorage.fruitsStorageMap.merge(fruit, quantityFruits, (oldVal, value)
                -> quantityFruits + previousQuantity);
    }
}
