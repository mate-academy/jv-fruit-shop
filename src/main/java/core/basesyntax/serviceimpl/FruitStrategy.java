package core.basesyntax.serviceimpl;

import core.basesyntax.service.OperationService;
import java.util.Map;

public class FruitStrategy {
    private final Map<FruitTransaction.Operation, OperationService> operationHandlers;

    public FruitStrategy(Map<FruitTransaction.Operation, OperationService> operationHandlers) {
        this.operationHandlers = operationHandlers;
    }

    public OperationService getOperationService(FruitTransaction.Operation type) {
        return operationHandlers.get(type);
    }
}
