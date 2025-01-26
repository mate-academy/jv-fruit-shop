package core.basesyntax.operation;

import core.basesyntax.model.FruitTransaction;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlers) {
        this.handlers = new HashMap<>(handlers);
    }

    @Override
    public void processTransaction(Map<String, Integer> storage, FruitTransaction transaction) {
        OperationHandler handler = handlers.get(transaction.getOperation());
        if (handler == null) {
            throw new IllegalArgumentException("No handler found" + transaction.getOperation());
        }
        handler.handle(storage, transaction);
    }
}
