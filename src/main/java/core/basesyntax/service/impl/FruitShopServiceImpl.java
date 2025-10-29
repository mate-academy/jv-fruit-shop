package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitShopServiceImpl implements FruitShopService {
    private final OperationStrategy strategy;
    private final Map<String, Integer> storage;

    public FruitShopServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
        this.storage = new HashMap<>();
    }

    @Override
    public Map<String, Integer> process(List<FruitTransaction> transactions) {

        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = strategy.getHandler(transaction.getOperation());
            handler.apply(transaction, storage);
        }
        return storage;
    }
}
