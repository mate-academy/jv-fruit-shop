package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationService;

public interface StrategyOperation {
    OperationService getOperationService(FruitTransaction.Operation operation);
}
