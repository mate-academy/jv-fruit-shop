package sevice.impl;

import java.util.List;
import java.util.Map;
import service.TransactionService;
import strategy.OperationStrategy;
import strategy.TransactionStrategy;

public class TransactionServiceImpl implements TransactionService {
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private String spliterator;
    private OperationStrategy operationStrategy;

    public TransactionServiceImpl(String spliterator, OperationStrategy operationStrategy) {
        this.spliterator = spliterator;
        this.operationStrategy = operationStrategy;
    }

    @Override
    public boolean transactionToDataBase(List<String> data,
                                         Map<String, TransactionStrategy> strategyMap) {
        if (data == null) {
            return false;
        }
        data.stream()
                .map(s -> s.split(spliterator))
                .forEach(s -> operationStrategy.getStrategy(s).apply(s[INDEX_OF_FRUIT],
                        Integer.parseInt(s[INDEX_OF_QUANTITY])));
        return true;
    }
}
