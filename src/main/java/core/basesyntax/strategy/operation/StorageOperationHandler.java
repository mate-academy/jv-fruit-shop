package core.basesyntax.strategy.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.db.dto.StorageOperationDTO;

public interface StorageOperationHandler {
    void handle(Storage storage, StorageOperationDTO storageOperation);
}
