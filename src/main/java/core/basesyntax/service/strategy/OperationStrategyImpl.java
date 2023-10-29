package core.basesyntax.service.strategy;

import core.basesyntax.service.calculator.OperationCalculator;
import core.basesyntax.service.operation.FruitOperation;
import java.util.Map;

public class OperationStrategyImpl implements OperationStrategy {
    private Map<FruitOperation.Operation, OperationCalculator> handlersMap;

    public OperationStrategyImpl(Map<FruitOperation.Operation, OperationCalculator> handlersMap) {
        this.handlersMap = handlersMap;
    }

    @Override
    public OperationCalculator getOperationType(FruitOperation fruitTransaction) {
        return handlersMap.get(fruitTransaction.getOperation());
    }
}
