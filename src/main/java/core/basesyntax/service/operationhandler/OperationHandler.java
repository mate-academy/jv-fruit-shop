package core.basesyntax.service.operationhandler;

import core.basesyntax.model.Transaction;

public interface OperationHandler {
    boolean apply(Transaction transaction);
}
