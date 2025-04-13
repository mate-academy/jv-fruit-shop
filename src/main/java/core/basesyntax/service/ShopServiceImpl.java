package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;
    private Map<String, Integer> storage;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
        storage = new HashMap<>();
    }

    public Map<String, Integer> getStorage() {
        return storage;
    }

    @Override
    public void proces(List<FruitTransaction> transactions) {
        for (FruitTransaction fruitTransaction : transactions) {
            operationStrategy.getHandler(fruitTransaction.getOperation())
                    .handle(fruitTransaction, storage);
        }
    }
}
