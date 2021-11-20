package core.basesyntax.strategy;

import core.basesyntax.service.OperationService;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
    private final Map<String, OperationService> operationsList;

    public OperationStrategy() {
        operationsList = new HashMap<>();
        Arrays.stream(OperationType.values())
                .forEach(t -> operationsList.put(t.getName(), t.getOperationType()));
    }

    public OperationService getService(String name) {
        return operationsList.get(name);
    }
}
