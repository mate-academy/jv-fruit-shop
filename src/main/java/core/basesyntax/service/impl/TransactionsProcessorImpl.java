package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.TransactionsProcessor;
import core.basesyntax.strategy.OperationStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TransactionsProcessorImpl implements TransactionsProcessor {
    private final OperationStrategy operationStrategy;

    public TransactionsProcessorImpl(OperationStrategy operationStrategy) {
        this.operationStrategy = operationStrategy;
    }

    @Override
    public Map<String, Integer> process(List<FruitTransaction> fruitTransactions) {
        Map<String, Integer> hashMap = new HashMap<>();
        fruitTransactions.forEach(fruitTransaction -> {
            int handleQuantity = operationStrategy
                    .getOperationHandler(fruitTransaction.getOperation())
                    .get(fruitTransaction, hashMap);
            hashMap.put(fruitTransaction.getFruit(), handleQuantity);
        });
        return hashMap;
    }
}
