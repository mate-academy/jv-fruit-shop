package core.basesyntax.operation.operationstrategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.operation.handler.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationHandler;

    public OperationStrategyImpl(
            Map<FruitTransaction.Operation, OperationHandler> operationHandler
    ) {
        this.operationHandler = operationHandler;
    }

    @Override
    public OperationHandler getHandler(FruitTransaction.Operation operation) {
        if (operation == null) {
            throw new RuntimeException("Operation cannot be null");
        }
        return operationHandler.get(operation);
    }
}
