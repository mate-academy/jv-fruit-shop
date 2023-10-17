package core.basesyntax.strategy.operation;

import core.basesyntax.db.dao.StorageDao;
import core.basesyntax.db.dto.StorageOperationDto;

public interface StorageOperationHandler {
    void handle(StorageDao storage, StorageOperationDto storageOperation);
}
