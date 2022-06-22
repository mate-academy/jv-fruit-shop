package servise.transaction;

import model.Transaction;

public interface TransactionHandler {
    Transaction getTransaction(String item, int quantity);
}
