package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.operations.DailyOperationHandler;

public interface OperationStrategy {
    DailyOperationHandler get(FruitTransaction.Operation type);
}
