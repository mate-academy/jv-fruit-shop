package core.basesyntax.servise;

import core.basesyntax.model.Operation;
import core.basesyntax.servise.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {

    private Map<Operation, OperationHandler> operationOperationHandlerMap;

    public OperationStrategyImpl(Map<Operation, OperationHandler> operationOperationHandlerMap) {
        this.operationOperationHandlerMap = operationOperationHandlerMap;
    }

    @Override
    public OperationHandler get(Operation operation) {
        return operationOperationHandlerMap.get(operation);
    }
}
