package core.basesyntax.service.impl;

import core.basesyntax.service.OperationService;

public class AddOperationService implements OperationService {
    @Override
    public int doCalculation(int totalQuantity, int quantity) {
        return totalQuantity += quantity;
    }
}
