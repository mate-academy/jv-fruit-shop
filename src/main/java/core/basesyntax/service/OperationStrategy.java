package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.Operation;

public interface OperationStrategy {
    Operation getOperation(FruitTransaction transaction);
}
