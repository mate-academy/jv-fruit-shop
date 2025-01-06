package operationStrategy;

import operationHandler.OperationHandler;
import transaction.FruitTransaction;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy{
    private final Map<FruitTransaction.Operation, OperationHandler> operationHandlers;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }
    @Override
    public OperationHandler getOperation(FruitTransaction.Operation operation) {
        return operationHandlers.get(operation);
    }
}
