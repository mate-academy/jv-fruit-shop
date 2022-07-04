package core.basesyntax.strategy;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private final Map<FruitTransaction.Operation, OperationHandler> operationsMap;

    public OperationStrategyImpl(Map<FruitTransaction.Operation, OperationHandler> map) {
        this.operationsMap = map;
    }

    @Override
    public OperationHandler get(FruitTransaction.Operation operation) {
        return operationsMap.get(operation);
    }
}
