package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandler;
import java.util.Map;

public class OperationStrategy {
    private final Map<FruitTransaction.Operation,
            core.basesyntax.service.OperationHandler> operationHandlerMap;

    public OperationStrategy(Map<FruitTransaction.Operation,
            OperationHandler> operationServiceMap) {
        this.operationHandlerMap = operationServiceMap;
    }

    public core.basesyntax.service.OperationHandler get(FruitTransaction.Operation operation) {
        return operationHandlerMap.get(operation);
    }
}
