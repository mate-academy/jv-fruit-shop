package core.basesyntax.service.impl;

import core.basesyntax.handler.OperationHandler;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        transactions.forEach(transaction -> {
            OperationHandler operationHandler = operationStrategy.get(transaction.getOperation());
            if (operationHandler == null) {
                throw new IllegalArgumentException("Unknown operation: "
                        + transaction.getOperation());
            }

            operationHandler.applyOperation(transaction);
        });
    }
}
