package service.impl;

import service.OperationService;

public class SupplyOperationService implements OperationService {

    @Override
    public int operate(String quantity) {
        return Integer.parseInt(quantity);
    }
}
