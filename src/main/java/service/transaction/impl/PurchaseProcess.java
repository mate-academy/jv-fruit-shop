package service.transaction.impl;

import service.transaction.HandlerTransaction;

public class PurchaseProcess implements HandlerTransaction {

    @Override
    public int perform(int balance, int quantity) {
        if (balance < quantity) {
            throw new RuntimeException("The PURCHASE transaction is not available. "
                    + "Not enough fruits on the balance(" + balance + ")");
        }
        return balance - quantity;
    }
}
