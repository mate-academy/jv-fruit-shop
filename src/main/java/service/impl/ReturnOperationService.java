package service.impl;

import service.OperationService;

public class ReturnOperationService implements OperationService {

    @Override
    public int operate(String quantity) {
        return Integer.parseInt(quantity);
    }
}
