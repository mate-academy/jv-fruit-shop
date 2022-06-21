package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public interface OperationMap {
    public OperationHandler get(FruitTransaction.Operation operation);
}
