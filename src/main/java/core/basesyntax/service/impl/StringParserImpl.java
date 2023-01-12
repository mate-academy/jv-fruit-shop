package core.basesyntax.service.impl;

import core.basesyntax.service.StringParser;
import core.basesyntax.strategy.FruitTransaction;
import core.basesyntax.strategy.FruitTransactionStrategy;
import java.util.List;

public class StringParserImpl implements StringParser {
    private static final int INDEX_TRANSACTION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;
    private static final String SEPARATOR = ",";
    private static final FruitTransactionStrategy fruitTransactionStrategy
            = new FruitTransactionStrategy();
    private FruitTransaction fruitTransaction;

    @Override
    public void considerFruit(List<String> fruitConsider) {
        for (int i = 1; i < fruitConsider.size(); i++) {
            String[] partsTransaction = fruitConsider.get(i).split(SEPARATOR);
            String transaction = partsTransaction[INDEX_TRANSACTION];
            String fruit = partsTransaction[INDEX_FRUIT];
            int quantity = Integer.parseInt(partsTransaction[INDEX_QUANTITY]);
            fruitTransaction = fruitTransactionStrategy.getTransaction(transaction);
            fruitTransaction.implementTransactionWithFruit(fruit, quantity);
        }
    }
}
