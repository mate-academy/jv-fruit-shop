package sevice.impl;

import java.util.List;
import java.util.Map;
import service.TransactionService;
import strategy.ChooserStrategy;
import strategy.TransactionStrategy;

public class TransactionServiceImpl implements TransactionService {
    private static final int INDEX_OF_FRUIT = 1;
    private static final int INDEX_OF_QUANTITY = 2;
    private String spliterator;
    private ChooserStrategy chooserStrategy;

    public TransactionServiceImpl(String spliterator, ChooserStrategy chooserStrategy) {
        this.spliterator = spliterator;
        this.chooserStrategy = chooserStrategy;
    }

    @Override
    public boolean transactionToDataBase(List<String> data,
                                         Map<String, TransactionStrategy> strategyMap) {
        if (data == null) {
            return false;
        }
        data.stream()
                .map(s -> s.split(spliterator))
                .forEach(s -> chooserStrategy.getStrategy(s).apply(s[INDEX_OF_FRUIT],
                        Integer.parseInt(s[INDEX_OF_QUANTITY])));
        return true;
    }
}
