package core.basesyntax.service;

import core.basesyntax.service.operations.IOperationHandler;
import core.basesyntax.strategy.OperationHandlerStrategy;

public class StorageService implements IStorageService {
    private final OperationHandlerStrategy handlerStrategy;

    public StorageService(OperationHandlerStrategy handlerStrategy) {
        this.handlerStrategy = handlerStrategy;
    }

    @Override
    public void operation(String operation, String fruit, Integer quantity) {
        if (checkData(operation, fruit, quantity)) {
            IOperationHandler operationHandler = handlerStrategy.chooseOperation(operation);
            operationHandler.handle(fruit, quantity);
        } else {
            throw new RuntimeException("Wrong data");
        }
    }

    private boolean checkData(String operation, String fruit, Integer quantity) {
        return operation != null && fruit != null && quantity != null
                && operation.length() == 1 && !fruit.isEmpty() && quantity < Integer.MAX_VALUE >> 2;
    }
}
