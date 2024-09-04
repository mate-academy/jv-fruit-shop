package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import core.basesyntax.service.impl.OperationStrategy;
import core.basesyntax.service.impl.ShopService;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final Map<String, Integer> storage = new HashMap<>();
    private final OperationStrategy operationStrategy;

    public ShopServiceImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public void process(List<FruitTransaction> fruitTransactionList) {
        for (FruitTransaction transaction : fruitTransactionList) {
            OperationHandler handler = operationStrategy.getHandler(transaction.getOperation());
            handler.handle(storage, transaction);
        }
    }

    @Override
    public Map<String, Integer> getStorage() {
        return storage;
    }
}
