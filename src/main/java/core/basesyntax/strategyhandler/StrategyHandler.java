package core.basesyntax.strategyhandler;

import core.basesyntax.storage.FruitTransaction;
import core.basesyntax.strategy.OperationHandler;
import java.util.List;
import java.util.Map;

public interface StrategyHandler {
    void strategyHandler(Map<FruitTransaction.Operation, OperationHandler> strategyMap,
                                     List<FruitTransaction> fruitTransactions);
}
