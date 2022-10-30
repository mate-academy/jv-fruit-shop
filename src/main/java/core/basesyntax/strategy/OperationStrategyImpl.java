package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
import core.basesyntax.service.OperationService;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<Operation, OperationService> operationServiceMap;

    public OperationStrategyImpl(Map<Operation, OperationService> operationServiceMap) {
        this.operationServiceMap = operationServiceMap;
    }

    @Override
    public OperationService get(Operation operation) {
        return operationServiceMap.get(operation);
    }
}
