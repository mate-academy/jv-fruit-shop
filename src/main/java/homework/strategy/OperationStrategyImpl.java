package homework.strategy;

import homework.service.impl.FruitTransaction;
import homework.strategy.handler.OperationHandler;
import java.util.HashMap;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    public static final Map<FruitTransaction.Operation, OperationHandler> operationsMap
            = new HashMap<>();

    @Override
    public OperationHandler get(FruitTransaction.Operation type) {
        return operationsMap.get(type);
    }
}
