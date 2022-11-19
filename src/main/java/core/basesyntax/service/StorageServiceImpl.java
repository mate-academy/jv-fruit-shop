package core.basesyntax.service;

import core.basesyntax.service.operations.OperationHandler;
import core.basesyntax.strategy.OperatioHandlerStrategyImpl;

public class StorageServiceImpl implements StorageService {
    private final OperatioHandlerStrategyImpl handlerStrategy;

    public StorageServiceImpl(OperatioHandlerStrategyImpl handlerStrategy) {
        this.handlerStrategy = handlerStrategy;
    }

    @Override
    public void operation(String operation, String fruit, Integer quantity) {
        if (checkData(operation, fruit, quantity)) {
            OperationHandler operationHandler = handlerStrategy.chooseOperation(operation);
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
