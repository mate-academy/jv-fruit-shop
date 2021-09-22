package core.basesyntax.service.operationtypes;

import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    private Map<Operations, OperationTypeHandler> operationTypeHandlerMap;

    public OperationStrategyImpl(Map<Operations, OperationTypeHandler> operationTypeHandlerMap) {
        this.operationTypeHandlerMap = operationTypeHandlerMap;
    }

    @Override
    public OperationTypeHandler get(Operations operation) {
        return operationTypeHandlerMap.get(operation);
    }
}
