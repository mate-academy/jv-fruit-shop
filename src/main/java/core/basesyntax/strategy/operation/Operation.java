package core.basesyntax.strategy.operation;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.operation.util.TransactionHandler;

public interface Operation {
    void apply(TransactionHandler transactionHandler, Transaction transaction);
}
