package service;

import java.util.List;
import model.Transaction;

public interface TransactionService {
    void processTransactions(List<Transaction> transactions);
}
