package core.basesyntax.services.strategy.impl;

import core.basesyntax.db.DataStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.services.strategy.OperationHandler;

public class PurchaseHandlerOperation implements OperationHandler {
    @Override
    public void operation(FruitTransaction fruitTransaction) {
        String fruits = fruitTransaction.getFruit();
        int quantityFruits = fruitTransaction.getQuantity();
        int quantity = DataStorage.fruitsStorageMap.get(fruits);
        DataStorage.fruitsStorageMap.put(fruits, quantity - quantityFruits);
    }
}
