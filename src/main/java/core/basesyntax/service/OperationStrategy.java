package core.basesyntax.service;

import core.basesyntax.service.strategy.Operations;
import core.basesyntax.service.strategy.OperationsType;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
    private Map<String, Operations> operationsMap = init();

    private Map<String, Operations> init() {
        Map<String, Operations> result = new HashMap<>();
        for (OperationsType operation : OperationsType.values()) {
            result.put(operation.getNameOfOperation(), operation.getOperation());
        }
        return result;
    }

    public Operations getOperationByName(String operationName) {
        return operationsMap.get(operationName);
    }
}
