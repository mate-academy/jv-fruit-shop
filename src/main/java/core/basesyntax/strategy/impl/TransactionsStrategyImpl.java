package core.basesyntax.strategy.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.strategy.TransactionsStrategy;
import java.util.Map;

public class TransactionsStrategyImpl implements TransactionsStrategy {
    private Map<String, FruitTransaction.Operation> operationMap;

    public TransactionsStrategyImpl(Map<String, FruitTransaction.Operation> operationMap) {
        this.operationMap = operationMap;
    }

    @Override
    public FruitTransaction.Operation get(String dataFromFile) {
        return operationMap.get(dataFromFile);
    }
}
