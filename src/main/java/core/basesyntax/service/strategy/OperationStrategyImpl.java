package core.basesyntax.service.strategy;

import core.basesyntax.service.strategy.handlers.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<String, OperationHandler> map;

    public OperationStrategyImpl(Map<String, OperationHandler> map) {
        this.map = map;
    }

    @Override
    public OperationHandler get(String operationType) {
        return map.get(operationType);
    }
}
