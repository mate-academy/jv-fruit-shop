package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operations.Operation;

public interface OperationStrategy {
    Operation get(FruitTransaction.Operation operation);
}
