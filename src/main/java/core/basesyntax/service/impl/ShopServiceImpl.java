package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.impl.OperationStrategyImpl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy strategy;
    private HashMap storage;

    public ShopServiceImpl() {
        strategy = new OperationStrategyImpl();
        storage = new HashMap<String, Integer>();
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            try {
                strategy.chooseHandler(transaction).handle(storage, transaction);
            } catch (RuntimeException e) {
                throw new RuntimeException("Error processing transaction: " + e.getMessage());
            }
        }
    }

    @Override
    public Map<String, Integer> getStorage() {
        return (Map<String, Integer>) storage.clone();
    }
}
