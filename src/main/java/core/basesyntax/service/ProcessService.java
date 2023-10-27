package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationType;
import core.basesyntax.strategy.Operation;
import java.util.List;
import java.util.Map;

public interface ProcessService {
    void processTransactions(List<FruitTransaction> fruitTransactionList, Map<OperationType,
            Operation> strategyMap);
}
