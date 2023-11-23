package main.service.Operation.Impl;

import main.service.Operation.OperationHandler;

public class PurchaseOperationHandler implements OperationHandler {
    @Override
    public int perform(int balance, int quantity) {
        if (balance < quantity) {
            throw new RuntimeException("Can`t perform operation PURCHASE. Not enough products on the balance");
        }
        return balance - quantity;
    }
}
