package core.basesyntax.strategy.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.util.Map;

public class OperationHandlerStrategyImpl implements OperationHandlerStrategy {
    private final Map<Transaction.Operation, OperationHandler> operationHandler;

    public OperationHandlerStrategyImpl(Map<Transaction.Operation,
            OperationHandler> operationHandler) {
        this.operationHandler = operationHandler;
    }

    @Override
    public OperationHandler getOperationHandler(Transaction.Operation operation) {
        return operationHandler.get(operation);
    }
}
