package core.basesyntax.strategy;

import core.basesyntax.db.dto.StorageOperationDto;
import core.basesyntax.strategy.operation.Operation;
import core.basesyntax.strategy.operation.StorageOperationHandler;
import java.util.HashMap;

public class VirtualStorageOperationStrategy implements StorageOperationStrategy {
    private final HashMap<Operation, StorageOperationHandler> operationHandlers;

    public VirtualStorageOperationStrategy(HashMap<Operation,
            StorageOperationHandler> operationHandlers) {

        this.operationHandlers = operationHandlers;
    }

    @Override
    public StorageOperationHandler getOperationHandler(StorageOperationDto storageOperation) {
        return operationHandlers.get(Operation.get(storageOperation.getType()));
    }
}
