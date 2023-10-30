package serviceimpl;

import java.util.Map;
import model.Operation;
import service.OperationStrategy;
import strategy.Operating;

public class OperationStrategyImpl implements OperationStrategy {

    private final Map<Operation, Operating> operationHandlersMap;

    public OperationStrategyImpl(Map<Operation, Operating> operationHandlersMap) {
        this.operationHandlersMap = operationHandlersMap;
    }

    @Override
    public Operating findRightStrategy(Operation operation) {
        return operationHandlersMap.get(operation);
    }
}
