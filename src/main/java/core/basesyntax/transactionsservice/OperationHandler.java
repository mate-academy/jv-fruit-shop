package core.basesyntax.transactionsservice;

import core.basesyntax.model.Transaction;

public interface OperationHandler {
    void proceed(Transaction transaction);
}
