package service.impl;

import service.OperationService;

public class SupplyService implements OperationService {
    @Override
    public int operate(int operationAmount, int balanceAmount) {
        return operationAmount + balanceAmount;
    }
}
