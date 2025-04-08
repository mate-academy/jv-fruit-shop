package core.basesyntax.strategyimpl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> handlers;

    public OperationStrategyImpl(Map<Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public void executeOperation(FruitTransaction transaction, Map<String, Integer> report) {
        OperationHandler handler = handlers.get(transaction.getOperation());
        if (handler == null) {
            throw new UnsupportedOperationException("Operation not supported: "
                    + transaction.getOperation());

        }
        handler.handle(transaction.getFruit(), transaction.getQuantity());
    }

    @Override
    public OperationHandler getHandler(Operation operation) {
        return handlers.get(operation);
    }
}
