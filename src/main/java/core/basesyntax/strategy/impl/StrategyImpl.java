package core.basesyntax.strategy.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.OperationHandler;
import core.basesyntax.strategy.Strategy;
import java.util.Map;

public class StrategyImpl implements Strategy {
    private final Map<Transaction.Operation, OperationHandler> operationHandlerMap;

    public StrategyImpl(Map<Transaction.Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler getActivity(Transaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
