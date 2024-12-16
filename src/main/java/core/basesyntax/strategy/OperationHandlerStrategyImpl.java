package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.handlers.OperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationHandlerStrategyImpl implements OperationHandlerStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandlers = new HashMap<>();

    public OperationHandlerStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    public Map<FruitTransaction.Operation, OperationHandler> getOperationHandlers() {
        return operationHandlers;
    }

    @Override
    public OperationHandler getOperationHandler(FruitTransaction transaction) {
        return operationHandlers.get(transaction.getOperation());
    }
}
