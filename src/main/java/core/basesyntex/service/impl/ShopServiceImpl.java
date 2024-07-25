package core.basesyntex.service.impl;

import core.basesyntex.model.FruitTransaction;
import core.basesyntex.service.OperationHandler;
import core.basesyntex.service.ShopService;
import core.basesyntex.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final OperationStrategy operationStrategy;
    private final Storage storage;

    public ShopServiceImpl(OperationStrategy operationStrategy, Storage storage) {
        this.operationStrategy = operationStrategy;
        this.storage = storage;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = operationStrategy.getHandler(transaction.getOperation());
            handler.handle(transaction, storage);
        }
    }

    public Map<String, Integer> getStorage() {
        return storage.getAll();
    }
}
