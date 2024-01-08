package core.basesyntax.services;

import core.basesyntax.models.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public interface FruitTransactionParser {
    void runOperationsOverFruit(List<FruitTransaction> operations,
                                OperationStrategy operationStrategy);
}
