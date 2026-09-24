package core.basesyntax.operationstrategy;

import core.basesyntax.fruittransaction.Operation;
import core.basesyntax.handlers.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Operation, OperationHandler> handlers;

    public OperationStrategyImpl(Map<Operation, OperationHandler> handlers) {
        this.handlers = handlers;
    }

    @Override
    public OperationHandler getTransactionHandler(Operation operation) {
        return handlers.get(operation);
    }
}
