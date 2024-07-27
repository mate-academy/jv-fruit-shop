package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.transaction.OperationHandler;

public interface StrategyFruitTransaction {
    OperationHandler execute(Operation operation);
}
