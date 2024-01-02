package core.basesyntax.services;

import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public interface FruitService {
    void runOtherOperationsOverFruit(List<String[]> otherOperations,
                                     OperationStrategy operationStrategy);
}
