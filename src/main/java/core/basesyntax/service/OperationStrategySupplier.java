package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationStrategy;

public interface OperationStrategySupplier {
    OperationStrategy get(FruitTransaction.Operation operation);
}
