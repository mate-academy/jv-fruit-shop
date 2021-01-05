package core.basesyntax.service.impl;

import core.basesyntax.model.Operation;
import core.basesyntax.model.Transaction;
import core.basesyntax.service.FruitService;
import core.basesyntax.service.strategy.OperationStrategy;
import java.util.List;
import java.util.Map;

public class FruitServiceImpl implements FruitService {
    private final Map<Operation, OperationStrategy> strategyMap;

    public FruitServiceImpl(Map<Operation, OperationStrategy> strategyMap) {
        this.strategyMap = strategyMap;
    }

    public Map<Operation, OperationStrategy> getStrategyMap() {
        return strategyMap;
    }

    @Override
    public void applyOperation(List<Transaction> transactions) {
        for (Transaction transaction : transactions) {
            OperationStrategy strategy = strategyMap.get(transaction.getOperation());
            strategy.apply(transaction);
        }
    }
}
