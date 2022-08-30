package core.basesyntax.service.impl;

import core.basesyntax.model.Transaction;
import core.basesyntax.service.GetStorageStatistic;
import core.basesyntax.strategy.OperationHandlerStrategy;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetStorageStatisticImpl implements GetStorageStatistic {
    private static final int ZERO = 0;
    private final OperationHandlerStrategy operationHandlerStrategy;

    public GetStorageStatisticImpl(OperationHandlerStrategy operationHandlerStrategy) {
        this.operationHandlerStrategy = operationHandlerStrategy;
    }

    @Override
    public Map<String,Integer> getStorageStatistic(List<Transaction> list) {
        Map<String,Integer> result = new HashMap<>();
        result.put("banana", ZERO);
        result.put("apple", ZERO);
        for (Transaction transaction : list) {
            result.put(transaction.getFruit().getName(),
                    operationHandlerStrategy.get(transaction.getOperation())
                    .apply(result.get(transaction.getFruit().getName()),
                            transaction.getQuantity()));
        }
        return result;
    }
}
