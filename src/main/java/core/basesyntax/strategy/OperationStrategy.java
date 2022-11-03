package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationService;
import java.util.Map;

public class OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationService> operationServiceMap;

    public OperationStrategy(Map<FruitTransaction.Operation,
            OperationService> operationServiceMap) {
        this.operationServiceMap = operationServiceMap;
    }

    public OperationService get(FruitTransaction.Operation operation) {
        return operationServiceMap.get(operation);
    }
}
