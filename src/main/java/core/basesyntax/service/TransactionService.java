package core.basesyntax.service;

import core.basesyntax.model.Transaction;
import java.util.List;

public interface TransactionService {
    boolean applyTransactions(List<Transaction> transactionList);
}
