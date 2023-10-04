package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;

public interface OperationHandler {
    void handler(Transaction transaction);
}
