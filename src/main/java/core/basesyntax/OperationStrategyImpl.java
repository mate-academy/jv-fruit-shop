package core.basesyntax;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> handlers;

    public OperationStrategyImpl(Map<Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public void executeOperation(FruitTransaction transaction, Map<String, Integer> report) {
        OperationHandler handler = handlers.get(transaction.getOperation());
        if (handler != null) {
            handler.handle(transaction.getFruit(), transaction.getQuantity());
        } else {
            throw new UnsupportedOperationException("Operation not supported: "
                    + transaction.getOperation());
        }
    }

    @Override
    public OperationHandler getHandler(Operation operation) {
        return handlers.get(operation);
    }
}

