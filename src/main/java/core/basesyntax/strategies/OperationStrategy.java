package core.basesyntax.strategies;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.services.operationhandler.IOperationHandler;
import java.util.Map;

public class OperationStrategy implements IOperationStrategy {
    private final Map<FruitTransaction.Operation, IOperationHandler> operationHandlerMap;

    public OperationStrategy(
            Map<FruitTransaction.Operation,
                    IOperationHandler> operationHandlerMap
    ) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public IOperationHandler get(FruitTransaction.Operation operation) {
        if (operation == null || !operationHandlerMap.containsKey(operation)) {
            throw new RuntimeException(operation + " operation is not supported");
        }

        return operationHandlerMap.get(operation);
    }
}
