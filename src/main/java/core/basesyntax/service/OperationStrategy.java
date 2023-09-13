package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(Transaction.Operation operation);
}
