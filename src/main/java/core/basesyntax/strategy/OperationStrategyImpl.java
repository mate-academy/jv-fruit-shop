package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public void apply(FruitTransaction transaction, Map<String, Integer> storage) {
        OperationHandler handler = handlers.get(transaction.getOperation());
        if (handler == null) {
            throw new RuntimeException("No handler found for operation: " + transaction.getOperation());
        }
        handler.apply(transaction, storage);
    }
}
