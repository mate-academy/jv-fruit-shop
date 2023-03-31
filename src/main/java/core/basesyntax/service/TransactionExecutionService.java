package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationStrategy;
import java.util.List;

public interface TransactionExecutionService {
    void executeTransaction(List<FruitTransaction> transactions,
                            OperationStrategy operationStrategy);
}
