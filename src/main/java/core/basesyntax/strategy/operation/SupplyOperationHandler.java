package core.basesyntax.strategy.operation;

import core.basesyntax.db.dao.StorageDao;
import core.basesyntax.db.dto.StorageItemDto;
import core.basesyntax.db.dto.StorageOperationDto;

public class SupplyOperationHandler implements StorageOperationHandler {
    @Override
    public void handle(StorageDao storage, StorageOperationDto storageOperation) {
        StorageItemDto storageItem = storageOperation.getStorageItem();

        if (storageItem.getQty() < 0) {
            throw new RuntimeException("Process income failed! Invalid value "
                    + storageItem.getQty() + " for item " + storageItem.getName());
        }

        storage.income(storageItem);
    }
}
