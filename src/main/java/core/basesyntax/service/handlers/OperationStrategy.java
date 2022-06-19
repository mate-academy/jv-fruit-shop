package core.basesyntax.service.handlers;

import core.basesyntax.model.Transaction;

public interface OperationStrategy {
    OperationHandler get(Transaction.Operation operation);
}
