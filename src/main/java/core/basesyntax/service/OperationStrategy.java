package core.basesyntax.service;

import core.basesyntax.service.implementations.FruitTransaction;
import core.basesyntax.service.operationhandler.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation type);
}
