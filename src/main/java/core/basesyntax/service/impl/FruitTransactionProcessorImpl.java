package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.FruitTransactionProcessor;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FruitTransactionProcessorImpl implements FruitTransactionProcessor {
    private final OperationStrategy operationStrategy;

    public FruitTransactionProcessorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> process(List<FruitTransaction> fruitTransactions) {
        Map<String, Integer> fruitsMap = new HashMap<>();
        fruitTransactions.forEach(fruitTransaction -> {
            int quantity = operationStrategy
                    .getOperationHandler(fruitTransaction.getOperation())
                    .calculate(fruitTransaction, fruitsMap);
            fruitsMap.put(fruitTransaction.getFruit(), quantity);
        });
        return fruitsMap;
    }
}
