package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operationsservice.FruitOperation;

public interface OperationStrategy {
    FruitOperation getOperation(FruitTransaction.Operation operation);
}
