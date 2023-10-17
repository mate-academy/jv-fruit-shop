package core.basesyntax.strategy.operation;

import core.basesyntax.db.dao.StorageDao;
import core.basesyntax.db.dto.StorageItemDto;
import core.basesyntax.db.dto.StorageOperationDto;

public class PurchaseOperationHandler implements StorageOperationHandler {
    @Override
    public void handle(StorageDao storage, StorageOperationDto storageOperation) {
        StorageItemDto storageItem = storageOperation.getStorageItem();
        StorageItemDto existingStorageItem = storage.getRemainder(storageItem.getName());

        if (storageItem.getQty() < 0) {
            throw new RuntimeException("Process outcome failed! Invalid value "
                    + storageItem.getQty() + " for item " + storageItem.getName());
        }

        if (existingStorageItem == null) {
            throw new RuntimeException("Process outcome failed! Item don't exists: "
                    + storageItem.getName());
        }

        if (existingStorageItem.getQty() < storageItem.getQty()) {
            throw new RuntimeException("Process outcome failed! Out of stock for product: "
                    + storageItem.getName() + " need " + storageItem.getQty()
                    + " but have " + existingStorageItem.getQty());
        }

        storage.outcome(storageItem);
    }
}
