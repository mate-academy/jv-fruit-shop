package service.impl;

import service.OperationService;

public class SupplyOperationService implements OperationService {
    @Override
    public int operate(int quantity) {
        return quantity;
    }
}
