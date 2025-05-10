package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> process(List<FruitTransaction> transactions) {
        Map<String, Integer> storage = new HashMap<>();

        for (FruitTransaction transaction : transactions) {
            operationStrategy.getOperationHandler(transaction
                    .getOperation()).handle(storage, transaction);
        }

        return storage;
    }
}
