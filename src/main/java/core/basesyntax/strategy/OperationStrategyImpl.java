package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operationsservice.FruitOperationHandler;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, FruitOperationHandler> operationsMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation,
            FruitOperationHandler> operationsMap) {
        this.operationsMap = operationsMap;
    }

    @Override
    public FruitOperationHandler getOperation(FruitTransaction.Operation operation) {
        return operationsMap.get(operation);
    }
}
