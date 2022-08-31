package core.basesyntax.strategy;

import core.basesyntax.strategy.impl.AddOperationServiceImpl;
import core.basesyntax.strategy.impl.SubtractOperationServiceImpl;
import java.util.HashMap;
import java.util.Map;

public class OperationServiceStrategy {
    private Map<String, OperationService> map;

    public OperationServiceStrategy() {
        map = new HashMap<>();
        map.put("b", new AddOperationServiceImpl());
        map.put("s", new AddOperationServiceImpl());
        map.put("p", new SubtractOperationServiceImpl());
        map.put("r", new AddOperationServiceImpl());
    }

    public OperationService getOperationServiceByOperationType(String operation) {
        return map.get(operation);
    }
}
