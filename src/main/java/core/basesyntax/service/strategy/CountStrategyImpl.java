package core.basesyntax.service.strategy;

import core.basesyntax.service.counter.OperationType;
import core.basesyntax.service.transaction.FruitTransaction;
import java.util.Map;

public class CountStrategyImpl implements CountStrategy {
    @Override
    public OperationType getOperationType(Map<String, OperationType> operationStrategyMap,
                                          FruitTransaction fruitTransaction) {
        return operationStrategyMap.get(fruitTransaction.getOperation().getCode());
    }
}
