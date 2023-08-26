package core.basesyntax.services.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import core.basesyntax.strategy.handlers.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    @Override
    public OperationHandler get(FruitTransaction.OperationType operation,
                                Map<FruitTransaction.OperationType,OperationHandler> map) {
        return map.get(operation);
    }
}
