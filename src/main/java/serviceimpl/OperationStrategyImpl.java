package serviceimpl;

import java.util.Map;
import model.FruitTransaction;
import service.OperationStrategy;
import strategy.Operating;

public class OperationStrategyImpl implements OperationStrategy {

    private final Map<FruitTransaction.Operation, Operating> operationHandlersMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, Operating> operationHandlersMap) {
        this.operationHandlersMap = operationHandlersMap;
    }

    @Override
    public Operating findRightStrategy(FruitTransaction.Operation operation) {
        return operationHandlersMap.get(operation);
    }
}
