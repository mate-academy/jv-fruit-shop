package core.basesyntax.services;

import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public interface FruitTransactionParser {
    void runOtherOperationsOverFruit(List<String[]> otherOperations,
                                     OperationStrategy operationStrategy);
}
