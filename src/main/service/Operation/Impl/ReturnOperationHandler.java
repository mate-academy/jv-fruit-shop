package main.service.Operation.Impl;

import main.service.Operation.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    @Override
    public int perform(int balance, int quantity) {
        return balance + quantity;
    }
}
