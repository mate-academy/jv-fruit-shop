package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactionsList) {
        for (FruitTransaction transaction : transactionsList) {
            OperationHandler handler = operationStrategy.get(transaction.getOperation());
            if (handler == null) {
                throw new IllegalArgumentException("No handler found for operation");
            }
            handler.apply(transaction);
        }
    }
}
