package service;

import java.util.List;
import model.Transaction;

public interface TransactionProcessor {
    boolean process(List<Transaction> transactions);
}
