package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.util.Operation;

public interface GetOperationService {
    Operation getOperationService(FruitTransaction fruitTransaction);
}
