package core.basesyntax.operations.operationstrategy;

import core.basesyntax.FruitTransaction;
import core.basesyntax.operations.operationhandlers.OperationHandler;
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
        return operationHandler.get(operation);
    }
}
