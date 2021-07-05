package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;

public interface OperationHandler {
    int apply(Transaction transaction);
}
