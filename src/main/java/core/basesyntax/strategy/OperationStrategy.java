package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.InputTransaction;

public interface OperationStrategy {
    InputTransaction get(FruitTransaction.Operation operation);
}
