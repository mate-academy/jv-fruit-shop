package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.util.Operation;

public interface OperationService {
    Operation getOperationService(FruitTransaction fruitTransaction);
}
