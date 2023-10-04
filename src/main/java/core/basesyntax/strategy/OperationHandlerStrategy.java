package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;

public interface OperationHandlerStrategy {
    OperationHandler getOperationHandler(Transaction.Operation operation);
}
