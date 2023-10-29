package core.basesyntax.strategy;

import core.basesyntax.model.Transaction;
import core.basesyntax.strategy.operations.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<Transaction.Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<Transaction.Operation, OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(Transaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
