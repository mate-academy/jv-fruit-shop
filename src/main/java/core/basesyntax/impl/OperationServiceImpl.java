package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationService;
import core.basesyntax.util.Operation;

public class OperationServiceImpl implements OperationService {
    @Override
    public Operation getOperationService(FruitTransaction fruitTransaction) {
        return fruitTransaction.getOperation();
    }
}
