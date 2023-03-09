package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface TransactionHandler {
    void handleTransactions(List<Transaction> transactionList);
}
