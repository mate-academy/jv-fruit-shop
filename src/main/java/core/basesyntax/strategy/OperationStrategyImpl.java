package core.basesyntax.strategy;

import core.basesyntax.model.Operation;
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

        for (Map.Entry<Operation,
                OperationHandler> entry :operationHandlerMap.entrySet()) {
            if (entry.getKey().getOperation().equals(type)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
