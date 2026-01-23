package core.basesyntax.serviceimpl;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> handlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public void handle(FruitTransaction transaction, Storage storage) {
        if (storage == null) {
            throw new IllegalArgumentException("Storage can't be null");
        }
        if (transaction == null) {
            throw new IllegalArgumentException("FruitTransaction can't be null");
        }
        OperationHandler handler = handlers.get(transaction.getOperation());
        if (handler == null) {
            throw new RuntimeException("No handler for operation: " + transaction.getOperation());
        }
        handler.handle(storage, transaction);
    }
}
