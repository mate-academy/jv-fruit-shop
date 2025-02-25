package service.impl;

import service.OperationService;

public class ReturnService implements OperationService {
    @Override
    public int operate(int operationAmount, int balanceAmount) {
        return operationAmount + balanceAmount;
    }
}
