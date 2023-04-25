package core.basesyntax.service.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operation.OperationHandler;

import java.util.Map;

public class OperationStrategyImp implements OperationStrategy {
    private Map<FruitTransaction.Operation, OperationHandler> operationMap;

    public OperationStrategyImp(Map<FruitTransaction.Operation, OperationHandler> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation type) {
        return operationMap.get(type);
    }
}
