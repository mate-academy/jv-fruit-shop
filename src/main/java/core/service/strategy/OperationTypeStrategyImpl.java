package core.service.strategy;

import core.exception.ValidationException;
import core.model.OperationType;
import core.service.operation.OperationTypeHandler;
import java.util.Map;

public class OperationTypeStrategyImpl implements OperationTypeStrategy {
    private Map<OperationType, OperationTypeHandler> handlerMap;

    public OperationTypeStrategyImpl(Map<OperationType, OperationTypeHandler> handlerMap) {
        this.handlerMap = handlerMap;
    }

    @Override
    public OperationTypeHandler getHandle(OperationType operationType) throws ValidationException {
        if (handlerMap.get(operationType) == null) {
            throw new ValidationException("Invalid OperationType " + operationType);
        }
        return handlerMap.get(operationType);
    }
}
