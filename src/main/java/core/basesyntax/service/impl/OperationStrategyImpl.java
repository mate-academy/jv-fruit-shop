package core.basesyntax.service.impl;

import core.basesyntax.service.OperationStrategy;
import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    @Override
    public OperationHandler getStrategy(
            Map<String, OperationHandler> operationHandlerMap, String[] line) {
        return operationHandlerMap.get(line[0]);
    }
}
