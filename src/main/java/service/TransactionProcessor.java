package service;

import java.util.List;
import model.Transaction;

public interface TransactionProcessor {
    void processTransaction(List<Transaction> transactionsList);
}
