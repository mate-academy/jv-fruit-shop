package core.basesyntax.strategy.impl;

import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class OperationStrategy {
    private Map<String, OperationHandler> map;

    public OperationStrategy(Map<String, OperationHandler> map) {
        this.map = map;
    }

    public OperationHandler getByOperation(String operation) {
        return map.get(operation);
    }
}
