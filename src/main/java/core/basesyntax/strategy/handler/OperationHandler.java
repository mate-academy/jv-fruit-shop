package core.basesyntax.strategy.handler;

import core.basesyntax.model.Transaction;

public interface OperationHandler {
    void apply(Transaction transaction);
}
