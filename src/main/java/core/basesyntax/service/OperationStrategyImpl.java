package core.basesyntax.service;

import core.basesyntax.dto.FruitRecordDto;
import core.basesyntax.service.handler.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitRecordDto.OperationType, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitRecordDto.OperationType,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(FruitRecordDto.OperationType operationType) {
        return operationHandlerMap.get(operationType);
    }
}
