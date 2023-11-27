package main.service.transaction.Impl;

import main.service.transaction.TransactionHandler;

public class ReturnTransactionHandler implements TransactionHandler {
    @Override
    public int perform(int balance, int quantity) {
        return balance + quantity;
    }
}
