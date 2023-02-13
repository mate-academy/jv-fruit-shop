package core.basesyntax.strategy;

import core.basesyntax.service.operation.Handler;
import java.util.Map;

public class StrategyOperationImpl implements StrategyOperation {
    private final Map<String, Handler> operationStrategyHashMap;

    public StrategyOperationImpl(Map<String, Handler> operationStrategyHashMap) {
        this.operationStrategyHashMap = operationStrategyHashMap;
    }

    @Override
    public Handler get(String operation) {
        return operationStrategyHashMap.get(operation);
    }
}
