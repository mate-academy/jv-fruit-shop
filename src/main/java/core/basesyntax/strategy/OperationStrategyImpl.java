package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransactionImpl;
import core.basesyntax.operationhandlers.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransactionImpl.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransactionImpl.Operation,
            OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    @Override
    public OperationHandler getHandler(FruitTransactionImpl.Operation operation) {
        return operationHandlers.get(operation);
    }
}
