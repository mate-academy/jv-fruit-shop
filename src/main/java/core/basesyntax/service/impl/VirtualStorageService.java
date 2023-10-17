package core.basesyntax.service.impl;

import core.basesyntax.db.dao.StorageDao;
import core.basesyntax.db.dao.VirtualStorageDao;
import core.basesyntax.db.dto.StorageItemDto;
import core.basesyntax.db.dto.StorageOperationDto;
import core.basesyntax.service.StorageService;
import core.basesyntax.strategy.StorageOperationStrategy;
import core.basesyntax.strategy.operation.StorageOperationHandler;
import java.util.List;

public class VirtualStorageService implements StorageService {
    private final StorageDao storageDao = new VirtualStorageDao();
    private final StorageOperationStrategy storageOperationStrategy;

    public VirtualStorageService(StorageOperationStrategy storageOperationStrategy) {
        this.storageOperationStrategy = storageOperationStrategy;
    }

    @Override
    public void clearStorage() {
        storageDao.clearStorage();
    }

    @Override
    public StorageItemDto getRemainder(String storageItemName) {
        return storageDao.getRemainder(storageItemName);
    }

    @Override
    public List<StorageItemDto> getRemainders() {
        return storageDao.getRemainders();
    }

    @Override
    public void update(StorageOperationDto storageOperation) {
        StorageOperationHandler storageOperationHandler =
                storageOperationStrategy.getOperationHandler(storageOperation);

        if (storageOperationHandler == null) {
            throw new RuntimeException("Executing operation failed! Invalid operation type: "
                    + storageOperation.getType());
        }

        storageOperationHandler.handle(storageDao, storageOperation);
    }

    @Override
    public void update(List<StorageOperationDto> storageOperationList) {
        for (StorageOperationDto storageOperation : storageOperationList) {
            update(storageOperation);
        }
    }
}
