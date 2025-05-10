package core.basesyntex.service.impl;

import core.basesyntex.model.FruitTransaction;
import core.basesyntex.service.OperationHandler;
import core.basesyntex.service.ShopService;
import core.basesyntex.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getHandler(transaction.getOperation());
            handler.handle(transaction);
        }
    }

    public Map<String, Integer> getStorage() {
        return Storage.getAll();
    }
}
