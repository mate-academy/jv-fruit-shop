package core.basesyntax.service;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation);
}
