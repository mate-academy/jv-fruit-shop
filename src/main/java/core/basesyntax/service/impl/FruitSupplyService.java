package core.basesyntax.service.impl;

import core.basesyntax.service.FruitOperationService;

public class FruitSupplyService implements FruitOperationService {
    @Override
    public int performOperation(int prev, int current) {
        return prev + current;
    }
}
