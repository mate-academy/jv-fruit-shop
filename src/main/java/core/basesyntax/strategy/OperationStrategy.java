package core.basesyntax.strategy;

import java.util.List;
import java.util.Map;

public interface OperationStrategy {
    void accept(List<String[]> data, Map<String, OperationHandler> operationHandlerMap);
}
