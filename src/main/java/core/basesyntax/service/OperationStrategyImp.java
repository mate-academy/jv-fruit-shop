package core.basesyntax.service;

import core.basesyntax.service.operation.OperationHandler;
import java.util.Map;

public class OperationStrategyImp implements OperationStrategy {

    private Map<FruitTransaction.Operation, OperationHandler> operationStrategyMap;

    public OperationStrategyImp(
            Map<FruitTransaction.Operation, OperationHandler> operationStrategyMap) {
        this.operationStrategyMap = operationStrategyMap;
    }

    @Override
    public OperationHandler strategy(FruitTransaction.Operation operation) {
        return operationStrategyMap.get(operation);
    }
}
