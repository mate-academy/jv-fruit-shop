package core.basesyntax.strategy;

import core.basesyntax.db.dto.StorageOperationDto;
import core.basesyntax.strategy.operation.Operation;
import core.basesyntax.strategy.operation.StorageOperationHandler;
import java.util.Map;

public class SimpleOperationStrategy implements OperationStrategy {
    private final Map<Operation, StorageOperationHandler> operationHandlers;

    public SimpleOperationStrategy(Map<Operation,
                StorageOperationHandler> operationHandlers) {

        this.operationHandlers = operationHandlers;
    }

    @Override
    public StorageOperationHandler getOperationHandler(StorageOperationDto storageOperation) {
        return operationHandlers.get(Operation.get(storageOperation.getType()));
    }
}
