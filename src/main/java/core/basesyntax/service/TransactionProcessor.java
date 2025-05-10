package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public interface TransactionProcessor {
    void process(List<FruitTransaction> fruitTransactions,
                 Map<FruitTransaction.Operation, OperationHandler> strategy);
}
