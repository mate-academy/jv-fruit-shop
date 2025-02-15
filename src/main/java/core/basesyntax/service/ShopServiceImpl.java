package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final Map<String, Integer> storage;

    public ShopServiceImpl(OperationStrategy operationStrategy,
                           Map<String, Integer> storage) {
        this.operationStrategy = operationStrategy;
        this.storage = storage;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getHandler(transaction.getOperation());
            if (handler != null) {
                handler.apply(transaction, storage);
            } else {
                throw new RuntimeException("No handler found for operation: " + transaction);
            }
        }
    }
}
