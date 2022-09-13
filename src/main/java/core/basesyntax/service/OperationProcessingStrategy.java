package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.TransactionsHandler;

public interface OperationProcessingStrategy {
    TransactionsHandler get(Transaction.Operation transaction);
}
