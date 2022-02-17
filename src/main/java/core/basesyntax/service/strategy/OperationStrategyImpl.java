package core.basesyntax.service.strategy;

import core.basesyntax.service.DataProcessorImpl;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<DataProcessorImpl.OperationType, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<DataProcessorImpl.OperationType, OperationHandler>
                                         operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(DataProcessorImpl.OperationType operationType) {
        return operationHandlerMap.get(operationType);
    }
}
