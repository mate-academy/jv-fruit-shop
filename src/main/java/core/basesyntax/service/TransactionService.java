package core.basesyntax.service;

import core.basesyntax.fruit.Transaction;
import java.util.List;

public interface TransactionService {
    void excuteTransactions(List<Transaction> transactionList);
}
