package service.impl;

import service.OperationService;

public class ReturnOperationService implements OperationService {
    @Override
    public int operate(int quantity) {
        return quantity;
    }
}
