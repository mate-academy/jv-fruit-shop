package core.basesyntax.strategy.operations;

import core.basesyntax.model.Transaction;

public interface OperationHandler {
    void proccessOperation(Transaction transaction);
}
