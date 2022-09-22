package core.basesyntax.service.operations;

import core.basesyntax.model.FruitTransaction;
import java.util.Map;

public class OperationsStrategyImpl implements OperationStrategy {
    private final Map<Operation, Operations> operationOperationsMap;

    public OperationsStrategyImpl(Map<Operation, Operations> operationOperationsMap) {
        this.operationOperationsMap = operationOperationsMap;
    }

    @Override
    public void doOperation(FruitTransaction fruitTransaction) {
        operationOperationsMap.get(fruitTransaction.getOperation()).realization(fruitTransaction);

    }
}
