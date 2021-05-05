package fruitshop.service;

import fruitshop.service.shopoperation.OperationHandler;
import fruitshop.service.shopoperation.OperationType;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final Map<OperationType, OperationHandler> operationMap;

    public FruitServiceImpl(Map<OperationType, OperationHandler> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public OperationHandler getOperation(OperationType operationType) {
        return operationMap.get(operationType);
    }
}
