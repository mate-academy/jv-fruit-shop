package core.basesyntax.service.impl;

import core.basesyntax.service.DataParserService;
import core.basesyntax.strategy.FruitTransaction;
import core.basesyntax.strategy.FruitTransactionStrategy;
import java.util.List;

public class DataParserServiceImpl implements DataParserService {
    private static final int TRANSACTION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String SEPARATOR = ",";
    private static final FruitTransactionStrategy fruitTransactionStrategy
            = new FruitTransactionStrategy();

    @Override
    public void parseData(List<String> fruitConsider) {
        for (int i = 1; i < fruitConsider.size(); i++) {
            String[] partsTransaction = fruitConsider.get(i).split(SEPARATOR);
            String transaction = partsTransaction[TRANSACTION_INDEX];
            String fruit = partsTransaction[FRUIT_INDEX];
            int quantity = Integer.parseInt(partsTransaction[QUANTITY_INDEX]);
            FruitTransaction fruitTransaction =
                    fruitTransactionStrategy.getTransaction(transaction);
            fruitTransaction.implementTransactionWithFruit(fruit, quantity);
        }
    }
}
