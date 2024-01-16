package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationProvider;

public interface OperationStrategy {
    OperationProvider get(FruitTransaction.Operation operation);
}
