package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.operation.FruitOperationHandler;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactionList) {
        for (FruitTransaction transaction : transactionList) {
            FruitOperationHandler operationHandler =
                    operationStrategy.get(transaction.getOperation());
            operationHandler.applyOperation(transaction.getFruit(),
                    transaction.getQuantity());
        }
    }
}
