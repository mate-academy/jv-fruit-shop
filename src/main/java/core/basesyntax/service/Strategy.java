package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;

public interface Strategy {
    OperationHandler getTypeOperation(FruitTransaction fruitTransaction);
}
