package core.basesyntax.transactionsService;

import core.basesyntax.model.Transaction;

public interface OperationHandler {
    void proceed(Transaction transaction);
}
