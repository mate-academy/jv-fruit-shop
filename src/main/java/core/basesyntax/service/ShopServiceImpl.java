package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.operations.OperationHandler;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void transfer(Operation operation, String fruit, Integer quantity) {
        FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
        OperationHandler handler = operationStrategy.get(operation);
        if (handler == null) {
            throw new RuntimeException("No handler found for operation: " + operation);
        }
        handler.apply(transaction);
    }
}
