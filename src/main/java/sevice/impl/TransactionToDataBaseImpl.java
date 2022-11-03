package sevice.impl;

import java.util.List;
import java.util.Map;
import service.TransactionToDataBase;
import strategy.TransactionStrategy;

public class TransactionToDataBaseImpl implements TransactionToDataBase {
    private static final int INDEX_OF_TRANSACTION = 0;
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private String spliterator;

    public TransactionToDataBaseImpl(String spliterator) {
        this.spliterator = spliterator;
    }

    @Override
    public boolean transactionToDataBase(List<String> data,
                                         Map<String, TransactionStrategy> strategyMap) {
        if (data == null) {
            return false;
        }
        data.stream()
                .map(s -> s.split(spliterator))
                .forEach(s -> strategyMap.get(s[INDEX_OF_TRANSACTION])
                                .doTransaction(s[INDEX_OF_FRUIT],
                        Integer.parseInt(s[INDEX_OF_QUANTITY])));
        return true;
    }
}
