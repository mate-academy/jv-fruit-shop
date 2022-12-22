package core.basesyntax.services.strategy.impl;

import core.basesyntax.db.DataStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.strategy.OperationHandler;

public class ReturnHandlerOperation implements OperationHandler {
    @Override
    public void operation(FruitTransaction fruitTransaction) {
        String fruits = fruitTransaction.getFruit();
        int quantityFruits = fruitTransaction.getQuantity();
        if (DataStorage.fruitsStorageMap.containsKey(fruits)) {
            int previousQuantity = DataStorage.fruitsStorageMap.get(fruits);
            DataStorage.fruitsStorageMap.put(fruits, previousQuantity + quantityFruits);
        } else {
            DataStorage.fruitsStorageMap.put(fruits, quantityFruits);
        }
    }
}
