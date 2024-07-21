package core.basesyntax.service.strategy;

import core.basesyntax.domain.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
