package service.transaction.impl;

import service.transaction.HandlerTransaction;

public class ReturnTransaction implements HandlerTransaction {
    @Override
    public int perform(int balance, int quantity) {
        return balance + quantity;
    }
}
