package core.basesyntax.operation;

import core.basesyntax.model.Transaction;

public interface OperationHandler {
    void execute(Transaction transaction);
}
