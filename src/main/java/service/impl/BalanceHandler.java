package service.impl;

import service.OperationHandler;

public class BalanceHandler implements OperationHandler {
    @Override
    public int operate(int operationAmount, int balanceAmount) {
        return operationAmount + balanceAmount;
    }
}
