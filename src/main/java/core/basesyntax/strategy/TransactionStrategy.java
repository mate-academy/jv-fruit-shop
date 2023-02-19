package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface TransactionStrategy {
    void processTransactions(List<Transaction> transactions);
}
