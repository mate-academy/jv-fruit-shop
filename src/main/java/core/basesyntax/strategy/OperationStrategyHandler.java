package core.basesyntax.strategy;

import java.util.Map;

public class OperationStrategyHandler {
    private Map<String, OperationHandler> map;

    public OperationStrategyHandler(Map<String, OperationHandler> map) {
        this.map = map;
    }

    public OperationHandler getByOperation(String operation) {
        return map.get(operation);
    }
}
