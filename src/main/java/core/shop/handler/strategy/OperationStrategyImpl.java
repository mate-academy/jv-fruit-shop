package core.shop.handler.strategy;

import core.shop.handler.OperationHandler;
import core.shop.model.OperationType;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<OperationType, OperationHandler> fruitMap;

    public OperationStrategyImpl(Map<OperationType, OperationHandler> fruitMap) {
        this.fruitMap = fruitMap;
    }

    @Override
    public OperationHandler getOperationHandler(OperationType operationType) {
        return fruitMap.get(operationType);
    }
}
