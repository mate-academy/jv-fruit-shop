package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationName;
import core.basesyntax.strategy.Action;
import java.util.List;
import java.util.Map;

public interface StrategyService {
    void processTransactions(Map<OperationName, Action> actionHashMap,
                             List<FruitTransaction> transactions);
}
