package core.basesyntax.service;

import core.basesyntax.strategy.OperationHandler;
import java.util.Map;

public interface OperationStrategy {
    OperationHandler getStrategy(Map<String, OperationHandler> operationHandlerMap, String[] line);
}
