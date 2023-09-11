package core.basesyntax;

import java.util.Map;

public class DefaultOperationStrategy implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> handlers;

    public DefaultOperationStrategy(Map<FruitTransaction.Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        return handlers.get(operation);
    }
}
