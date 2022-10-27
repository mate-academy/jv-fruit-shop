package core.basesyntax.strategy;

import core.basesyntax.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;

    private Map<Operation, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<Operation,
            OperationHandler> operationOperationHandlerMap) {
        this.operationHandlerMap = operationOperationHandlerMap;
    }

    @Override
    public OperationHandler getHandler(String line) {
        String type = line.split(SEPARATOR)[OPERATION_INDEX];
        for (Operation operation : Operation.values()) {
            if (operation.getOperation().equals(type)) {
                return operationHandlerMap.get(operation);
            }
        }
        return null;
    }
}
