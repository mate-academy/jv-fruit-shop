package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private static OperationStrategy operationStrategy;
    private final Map<String, Integer> storage = new HashMap<>();

    public ShopServiceImpl(OperationStrategy operationStrategyParam) {
        operationStrategy = operationStrategyParam;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            operationStrategy.applyOperation(transaction.getOperation(),
                    transaction.getFruit(), transaction.getQuantity(), storage);
        }
    }

    @Override
    public Map<String, Integer> getStorage() {
        return storage;
    }
}
