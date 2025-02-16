package core.basesyntax.service;

import core.basesyntax.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;
import java.util.Optional;

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
        transactions
                .forEach(transaction -> Optional.ofNullable(operationStrategy
                                .getHandler(transaction.getOperation()))
                        .orElseThrow(() -> new RuntimeException("No handler found for operation: "
                                + transaction))
                        .apply(transaction, storage));
    }
}
