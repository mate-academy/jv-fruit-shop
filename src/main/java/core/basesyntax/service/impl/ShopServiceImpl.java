package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        if (operationStrategy == null) {
            throw new IllegalArgumentException("OperationStrategy cannot be null");
        }
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new IllegalArgumentException("Transaction list cannot be null");
        }

        for (FruitTransaction transaction : transactions) {
            if (transaction == null) {
                throw new IllegalArgumentException("Transaction cannot be null");
            }

            Operation operation = transaction.getOperation();
            if (operation == null) {
                throw new IllegalArgumentException("Transaction operation cannot be null");
            }

            OperationHandler handler = operationStrategy.get(operation);
            if (handler == null) {
                throw new IllegalArgumentException("No handler found for operation: " + operation);
            }

            handler.apply(transaction);
        }
    }
}
