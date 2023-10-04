package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handler.OperationHandler;
import java.util.Map;

public interface OperationStrategy {
    OperationHandler get(FruitTransaction.Operation operation,
                         Map<FruitTransaction.Operation, OperationHandler> map);
}
