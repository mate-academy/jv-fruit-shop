package core.basesyntax.strategy.operation;

import core.basesyntax.db.dao.StorageDao;
import core.basesyntax.db.dto.StorageItemDto;
import core.basesyntax.db.dto.StorageOperationDto;

public class BalanceOperationHandler implements StorageOperationHandler {
    @Override
    public void handle(StorageDao storage, StorageOperationDto storageOperation) {
        StorageItemDto storageItem = storageOperation.getStorageItem();
        StorageItemDto existingStorageItem = storage.getRemainder(storageItem.getName());

        if (storageItem.getQty() < 0) {
            throw new RuntimeException("Set remainder failed! Invalid value "
                    + storageItem.getQty() + " for item " + storageItem.getName());
        }

        if (existingStorageItem != null) {
            throw new RuntimeException("Set remainder failed! Item already exists: "
                    + storageItem.getName());
        }

        storage.setRemainder(storageItem);
    }
}
