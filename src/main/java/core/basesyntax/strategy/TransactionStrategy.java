package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.transaction.TransactionHandler;

import java.util.List;

public interface TransactionStrategy {
    void processTransaction(List<Transaction> transactions);

    TransactionHandler get(Operation operation);
}
