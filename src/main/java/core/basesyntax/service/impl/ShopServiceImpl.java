package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.ShopService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {

    private final Map<String, Integer> storage = new HashMap<>();
    private final OperationStrategy strategy;

    public ShopServiceImpl(OperationStrategy strategy) {
        this.strategy = strategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction tx : transactions) {
            strategy.get(tx.getOperation()).process(tx, storage);
        }
    }

    @Override
    public Map<String, Integer> getStorage() {
        return storage;
    }
}
