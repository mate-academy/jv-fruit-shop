package core.basesyntax.strategy.impl;

import core.basesyntax.hadler.OperationHandler;
import core.basesyntax.model.FruitTransaction.Operation;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> handlersMap;

    public OperationStrategyImpl(Map<Operation, OperationHandler> handlersMap) {
        this.handlersMap = handlersMap;
    }

    @Override
    public OperationHandler get(Operation operation) {
        return handlersMap.get(operation);
    }
}
