package core.basesyntax.service.strategy.impl;

import core.basesyntax.service.DataProcessorImpl;
import core.basesyntax.service.strategy.OperationHandler;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<DataProcessorImpl.OperationType, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<DataProcessorImpl.OperationType, OperationHandler>
                                         operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(DataProcessorImpl.OperationType operationType) {
        return operationHandlerMap.get(operationType);
    }
}
