package servise.transaction.impl;

import model.Transaction;
import servise.transaction.TransactionHandler;

public class SupplyTransactionHandler implements TransactionHandler {
    @Override
    public Transaction getTransaction(String item, int quantity) {
        return new Transaction(Transaction.Operation.SUPPLY, item, quantity);
    }
}
