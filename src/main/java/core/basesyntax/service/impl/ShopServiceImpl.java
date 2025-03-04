package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationHandler;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;
    private final Map<String, Integer> storage = new HashMap<>();

    public ShopServiceImpl(Map<FruitTransaction.Operation, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            operationHandlers.get(transaction.getOperation()).apply(transaction, storage);
        }
    }

    public Map<String, Integer> getStorage() {
        return storage;
    }
}
