package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operations.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
