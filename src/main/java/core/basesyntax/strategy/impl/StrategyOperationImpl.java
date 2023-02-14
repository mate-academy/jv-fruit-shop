package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.operation.OperationService;
import core.basesyntax.strategy.StrategyOperation;
import java.util.Map;

public class StrategyOperationImpl implements StrategyOperation {
    private final Map<FruitTransaction.Operation, OperationService> operationServiceMap;

    public StrategyOperationImpl(Map<FruitTransaction.Operation, OperationService> map) {
        this.operationServiceMap = map;
    }

    @Override
    public OperationService getOperationService(FruitTransaction.Operation operation) {
        return operationServiceMap.get(operation);
    }
}
