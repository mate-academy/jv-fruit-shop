package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;

public interface OperationService {
    void processOperation(FruitTransaction operation);
}
