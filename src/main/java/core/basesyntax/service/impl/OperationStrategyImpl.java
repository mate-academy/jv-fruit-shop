package core.basesyntax.service.impl;

import core.basesyntax.model.FruitOperationDto;
import core.basesyntax.service.OperationStrategy;
import core.basesyntax.service.operationstrategy.OperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitOperationDto.Type, OperationHandler> operationHandlerMap;

    public OperationStrategyImpl(Map<FruitOperationDto.Type,
            OperationHandler> operationHandlerMap) {
        this.operationHandlerMap = operationHandlerMap;
    }

    @Override
    public OperationHandler get(FruitOperationDto.Type type) {
        return operationHandlerMap.get(type);
    }
}
