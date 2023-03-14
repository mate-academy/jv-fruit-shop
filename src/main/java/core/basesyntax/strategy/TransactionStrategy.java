package core.basesyntax.strategy;

import core.basesyntax.model.StorageTransaction;
import java.util.Map;

public class TransactionStrategy implements Strategy {
    private Map<StorageTransaction.Operation, TransactionHandler> handlers;

    public TransactionStrategy(Map<StorageTransaction.Operation, TransactionHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public TransactionHandler getHandler(StorageTransaction transaction) {
        return handlers.get(transaction.getOperation());
    }
}
