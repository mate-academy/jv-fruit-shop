package core.basesyntax.strategy;

import core.basesyntax.db.dto.StorageOperationDto;
import core.basesyntax.strategy.operation.StorageOperationHandler;

public interface OperationStrategy {
    StorageOperationHandler getOperationHandler(StorageOperationDto storageOperation);
}
