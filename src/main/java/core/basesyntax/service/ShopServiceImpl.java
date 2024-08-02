package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operationstrategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final Map<String, Integer> storage = new HashMap<>();

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            operationStrategy.applyOperation(transaction.getOperation(), transaction.getFruit(),
                    transaction.getQuantity(), storage);
        }
    }

    public Map<String, Integer> getStorage() {
        return storage;
    }
}

