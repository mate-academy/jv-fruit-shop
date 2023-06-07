package core.basesyntax.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.GetOperationService;
import core.basesyntax.util.Operation;

public class GetOperationServiceImpl implements GetOperationService {
    @Override
    public Operation getOperationService(FruitTransaction fruitTransaction) {
        return fruitTransaction.getOperation();
    }
}
