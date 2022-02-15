package core.basesyntax.service.operation;

import core.basesyntax.service.FruitTransaction;
import java.util.Map;

public class OperationStrategyImp implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationOperationHandlerMap;

    public OperationStrategyImp(Map<FruitTransaction.Operation, OperationHandler>
                                        operationOperationHandlerMap) {
        this.operationOperationHandlerMap = operationOperationHandlerMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationOperationHandlerMap.get(operation);
    }
}
