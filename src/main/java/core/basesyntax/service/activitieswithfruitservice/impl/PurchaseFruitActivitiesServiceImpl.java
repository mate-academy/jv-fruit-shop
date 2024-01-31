package core.basesyntax.service.activitieswithfruitservice.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.activitieswithfruitservice.TransactionHandler;

public class PurchaseFruitActivitiesServiceImpl implements TransactionHandler {
    @Override
    public void performTransaction(FruitTransaction fruitTransaction) {
        String fruit = fruitTransaction.getFruit();
        Integer quantity = fruitTransaction.getQuantity();

        Integer totalFruitInStorage = Storage.fruitStorage.get(fruit);

        if (totalFruitInStorage == null || totalFruitInStorage < quantity) {
            throw new RuntimeException("Insufficient quantity of " + fruit + " in the storage");
        }

        Integer fruitInStorageAfterPurchase = totalFruitInStorage - quantity;
        Storage.fruitStorage.replace(fruit, fruitInStorageAfterPurchase);
    }
}
