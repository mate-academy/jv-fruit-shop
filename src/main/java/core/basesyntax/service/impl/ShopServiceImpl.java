package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategyImpl;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategyImpl operationStrategy;

    public ShopServiceImpl(OperationStrategyImpl operationStrategy) {
        if (operationStrategy == null) {
            throw new IllegalArgumentException("Processing strategy cannot be null");
        }
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new IllegalArgumentException("The list of transactions cannot be null.");
        }
        for (FruitTransaction transaction : transactions) {
            FruitTransaction.Operation operation = transaction.getOperation();
            OperationHandler handler = operationStrategy.get(operation);
            if (handler == null) {
                throw new IllegalArgumentException(
                        "No handler found for operation: " + operation);
            }
            handler.apply(transaction);
        }
    }
}
