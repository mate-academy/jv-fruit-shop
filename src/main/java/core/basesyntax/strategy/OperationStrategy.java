package core.basesyntax.strategy;

import core.basesyntax.service.FruitTransaction;
import core.basesyntax.service.operationwithfruits.OperationHandler;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operator);
}
