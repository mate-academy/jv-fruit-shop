package core.basesyntax.strategy;

import core.basesyntax.service.FruitOperationsHandler;
import core.basesyntax.service.FruitTransaction;

public interface OperationStrategy {
    FruitOperationsHandler get(FruitTransaction.Operation operation);
}
