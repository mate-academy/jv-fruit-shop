package core.basesyntax.strategy;

import core.basesyntax.service.operations.OperationHandler;
import core.basesyntax.template.FruitTransaction;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operationType);
}
