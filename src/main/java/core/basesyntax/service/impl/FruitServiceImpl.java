package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.Operation;
import core.basesyntax.service.TrasactionExecutor;
import core.basesyntax.strategy.FruitOperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements TrasactionExecutor {
    private final Map<Operation, FruitOperationStrategy> strategyMap;

    public FruitServiceImpl(Map<Operation, FruitOperationStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    @Override
    public void processTransactions(List<FruitTransaction> transactions) {
        FruitOperationStrategy strategy;
        for (FruitTransaction transaction : transactions) {
            strategy = strategyMap.get(transaction.getOperation());
            strategy.apply(transaction);
        }
    }
}
