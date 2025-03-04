package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.ShopService;
import core.basesyntax.strategy.OperationHandler;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopServiceImpl implements ShopService {
    private final Map<FruitTransaction.Operation, OperationHandler> handlers;
    private final Map<String, Integer> storage = new HashMap<>();

    public ShopServiceImpl(Map<FruitTransaction.Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public void process(List<FruitTransaction> transactions) {
        for (FruitTransaction transaction : transactions) {
            OperationHandler handler = handlers.get(transaction.getOperation());
            handler.apply(transaction, storage);
        }
    }

    @Override
    public Map<String, Integer> getStorage() {
        return Collections.unmodifiableMap(storage);
    }
}
