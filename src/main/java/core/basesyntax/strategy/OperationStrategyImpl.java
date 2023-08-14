package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.OperationHandlerService;
import core.basesyntax.service.OperationStrategyService;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategyService {
    private final Map<FruitTransaction.Operation, OperationHandlerService> operationHandleMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            OperationHandlerService> operationHandleMap) {
        this.operationHandleMap = operationHandleMap;
    }

    @Override
    public OperationHandlerService getHandler(FruitTransaction.Operation operation) {
        return operationHandleMap.get(operation);
    }
}
