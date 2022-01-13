package core.basesyntax.operationstrategy;

import java.util.HashMap;
import java.util.Map;

public class OperationStrategy {
    private final Map<String, OperationHandler> mapOperation = new HashMap<>();

    {
        mapOperation.put("b", new AddOperationHandler());
        mapOperation.put("s", new AddOperationHandler());
        mapOperation.put("p", new ReduceOperationHandler());
        mapOperation.put("r", new AddOperationHandler());
    }

    public OperationHandler get(String operation) {
        return mapOperation.get(operation);
    }
}
