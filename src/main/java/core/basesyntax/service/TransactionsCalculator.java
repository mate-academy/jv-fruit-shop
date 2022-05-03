package core.basesyntax.service;

import core.basesyntax.models.Transaction;
import java.util.List;

public interface TransactionsCalculator {
    void handleTransactions(List<Transaction> transactionsList);
}
