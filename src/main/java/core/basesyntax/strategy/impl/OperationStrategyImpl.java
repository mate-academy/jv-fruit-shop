package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlers;
    private final Map<String, Integer> storage;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlers,
                                 Map<String, Integer> storage) {
        this.handlers = handlers;
        this.storage = storage;
    }

    public Map<String, Integer> getStorage() {
        return storage;
    }

    @Override
    public void apply(FruitTransaction transaction) {
        OperationHandler handler = handlers.get(transaction.getOperation());

        if (handler == null) {
            throw new RuntimeException("No handler for operation: " + transaction.getOperation());
        }
        handler.apply(transaction, storage);
    }
}
