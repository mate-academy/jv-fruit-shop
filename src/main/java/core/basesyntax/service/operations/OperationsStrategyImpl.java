package core.basesyntax.service.operations;

import core.basesyntax.model.Operations;
import java.util.Map;

public class OperationsStrategyImpl implements OperationsStrategy {
    private final Map<Operations, OperationsHandler> operationsHandlerMap;

    public OperationsStrategyImpl(Map<Operations, OperationsHandler> operationsHandlerMap) {
        this.operationsHandlerMap = operationsHandlerMap;
    }

    @Override
    public OperationsHandler get(Operations operation) {
        return operationsHandlerMap.get(operation);
    }
}
