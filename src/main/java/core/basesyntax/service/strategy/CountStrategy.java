package core.basesyntax.service.strategy;

import core.basesyntax.service.counter.OperationType;
import core.basesyntax.service.transaction.FruitTransaction;
import java.util.Map;

public interface CountStrategy {

    OperationType getOperationType(Map<String, OperationType> operationStrategyMap,
                                   FruitTransaction fruitTransaction);
}
