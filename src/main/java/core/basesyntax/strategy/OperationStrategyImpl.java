package core.basesyntax.strategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> handlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return handlers.get(operation);
    }
}
