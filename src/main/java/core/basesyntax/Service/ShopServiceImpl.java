package core.basesyntax.Service;

import core.basesyntax.Model.FruitTransaction;
import core.basesyntax.Operation.OperationStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final Map<String, Integer> storage = new HashMap<>();

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            operationStrategy.processTransaction(storage, transaction);
        }
        return new HashMap<>(storage);
    }
}
