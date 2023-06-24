package core.basesyntax.operations;

import core.basesyntax.model.Transaction;

public interface OperationHandler {
    void apply(Transaction transaction);
}
