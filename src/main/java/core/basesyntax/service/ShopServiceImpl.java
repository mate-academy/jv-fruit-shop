package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final Map<String, Integer> stock = new HashMap<>();
    private final OperationStrategy strategy;

    public ShopServiceImpl(OperationStrategy strategy) {
        if (strategy == null) {
            throw new RuntimeException("OperationStrategy is null");
        }
        this.strategy = strategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        if (transactions == null) {
            throw new RuntimeException("Transaction list is null");
        }
        for (FruitTransaction transaction : transactions) {
            if (transaction == null) {
                throw new RuntimeException("Transaction in the list is null");
            }
            OperationHandler handler = strategy.getHandler(transaction.getOperation());
            if (handler == null) {
                throw new RuntimeException("No handler found for operation: "
                        + transaction.getOperation());
            }
            handler.handle(transaction, stock);
        }
    }

    @Override
    public Map<String, Integer> getCurrentStock() {
        return Collections.unmodifiableMap(new HashMap<>(stock));
    }
}
