package java.core.basesyntax.service.impl;

import java.core.basesyntax.model.Operation;
import java.core.basesyntax.strategy.FruitOperationStrategy;
import java.util.List;
import java.util.Map;
import java.core.basesyntax.model.FruitTransaction;
import java.core.basesyntax.service.FruitService;

public class FruitServiceImpl implements FruitService {
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
