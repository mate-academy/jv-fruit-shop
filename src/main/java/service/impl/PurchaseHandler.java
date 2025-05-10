package service.impl;

import service.OperationHandler;

public class PurchaseHandler implements OperationHandler {
    @Override
    public int operate(int operationAmount, int balanceAmount) {
        return balanceAmount - operationAmount;
    }
}
