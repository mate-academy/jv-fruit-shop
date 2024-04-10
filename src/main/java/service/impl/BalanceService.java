package service.impl;

import service.OperationService;

public class BalanceService implements OperationService {
    @Override
    public int operate(int quantity) {
        return quantity;
    }
}
