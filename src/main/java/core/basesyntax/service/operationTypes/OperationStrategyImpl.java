package core.basesyntax.service.operationTypes;

import java.util.Map;

//
public class OperationStrategyImpl implements OperationStrategy{

    private Map<String, OperationTypeHandler> operationTypeHandlerMap;

    public OperationStrategyImpl(Map<String, OperationTypeHandler> operationTypeHandlerMap) {
        this.operationTypeHandlerMap = operationTypeHandlerMap;
    }

    @Override
    public OperationTypeHandler get(String operation) {
        return operationTypeHandlerMap.get(operation);
    }
}
