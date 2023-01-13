package core.basesyntax.service.impl;

import core.basesyntax.service.DataTransactionService;
import core.basesyntax.strategy.FruitTransactionHandler;
import core.basesyntax.strategy.FruitTransactionStrategy;
import core.basesyntax.strategy.impl.FruitTransactionStrategyImpl;
import java.util.List;

public class DataTransactionServiceImpl implements DataTransactionService {
    private static final int TRANSACTION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";
    private final FruitTransactionStrategy fruitTransactionStrategy;

    public DataTransactionServiceImpl() {
        fruitTransactionStrategy = new FruitTransactionStrategyImpl();
    }

    @Override
    public void parseData(List<String> fruitConsider) {
        for (int i = 1; i < fruitConsider.size(); i++) {
            String[] partsTransaction = fruitConsider.get(i).split(SEPARATOR);
            String transaction = partsTransaction[TRANSACTION_INDEX];
            String fruit = partsTransaction[FRUIT_INDEX];
            int quantity = Integer.parseInt(partsTransaction[QUANTITY_INDEX]);
            FruitTransactionHandler fruitTransaction =
                    fruitTransactionStrategy.getTransaction(transaction);
            fruitTransaction.handleTransaction(fruit, quantity);
        }
    }
}
