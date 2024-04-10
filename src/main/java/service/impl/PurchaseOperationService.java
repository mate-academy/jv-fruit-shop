package service.impl;

import service.OperationService;

public class PurchaseOperationService implements OperationService {
    @Override
    public int operate(int quantity) {
        return -quantity;
    }
}
