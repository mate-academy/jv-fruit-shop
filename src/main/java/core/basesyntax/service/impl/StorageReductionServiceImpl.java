package core.basesyntax.service.impl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.Fruit;
import core.basesyntax.service.StorageService;
import core.basesyntax.service.TransactionLog;

public class StorageReductionServiceImpl implements StorageService {

    @Override
    public void actionToStorage(TransactionLog transactionLog, Storage storage) {
        for (Fruit fruit : storage.getShopStorage().keySet()) {
            if (fruit.getName().equals(transactionLog.getFruitName())) {
                int oldValue = storage.getShopStorage().get(fruit);
                if (oldValue >= transactionLog.getFruitQuantity()) {
                    storage.getShopStorage()
                            .replace(fruit, oldValue - transactionLog.getFruitQuantity());
                } else {
                    throw new RuntimeException("Not enough " + fruit.getName()
                            + "s in the storage");
                }
            }
        }
    }
}
