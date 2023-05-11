package core.basesyntax.service.impl;

import core.basesyntax.service.OperationService;

public class SubtractOperationService implements OperationService {
    @Override
    public int doCalculation(int totalQuantity, int quantity) {
        return totalQuantity -= quantity;
    }
}
