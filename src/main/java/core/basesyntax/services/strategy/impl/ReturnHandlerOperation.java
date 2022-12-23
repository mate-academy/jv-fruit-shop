package core.basesyntax.services.strategy.impl;

import core.basesyntax.db.DataStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.strategy.OperationHandler;

public class ReturnHandlerOperation implements OperationHandler {
    @Override
    public void operate(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        int quantityFruits = fruitTransaction.getQuantity();
        if (DataStorage.fruitsStorageMap.containsKey(fruit)) {
            int previousQuantity = DataStorage.fruitsStorageMap.get(fruit);
            DataStorage.fruitsStorageMap.put(fruit, previousQuantity + quantityFruits);
        } else {
            DataStorage.fruitsStorageMap.put(fruit, quantityFruits);
        }
    }
}
