package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handlers.OperationHandler;

import java.util.Map;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.OperationType operation,
                         Map<FruitTransaction.OperationType,OperationHandler> map);
}
