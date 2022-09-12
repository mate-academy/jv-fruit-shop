package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.TransactionsHandling;

public interface OperationProcessingStrategy {
    TransactionsHandling get(Transaction.Operation transaction);
}
