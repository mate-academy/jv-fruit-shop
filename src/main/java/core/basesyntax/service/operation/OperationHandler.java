package core.basesyntax.service.operation;

import core.basesyntax.model.Transaction;

public interface OperationHandler {
    void operation(Transaction transaction);
}
