package core.basesyntax.service;

import core.basesyntax.model.FruitStorage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationStrategy;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            operationStrategy.processTransaction(transaction);
        }
        return FruitStorage.getStorage();
    }
}

