package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.operationsservice.FruitOperation;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitTransaction.Operation, FruitOperation> operationsMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, FruitOperation> operationsMap) {
        this.operationsMap = operationsMap;
    }

    @Override
    public FruitOperation getOperation(FruitTransaction.Operation operation) {
        return operationsMap.get(operation);
    }
}
