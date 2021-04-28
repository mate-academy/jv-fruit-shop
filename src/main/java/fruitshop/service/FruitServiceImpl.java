package fruitshop.service;

import fruitshop.service.operation.OperationHandler;
import fruitshop.service.operation.OperationType;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final Map<OperationType, OperationHandler> operationMap;

    public FruitServiceImpl(Map<OperationType, OperationHandler> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public OperationHandler get(OperationType operationType) {
        return operationMap.get(operationType);
    }
}
