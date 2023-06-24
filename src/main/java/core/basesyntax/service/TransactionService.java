package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface TransactionService {
    void executeTransactions(List<Transaction> transactionList);
}
