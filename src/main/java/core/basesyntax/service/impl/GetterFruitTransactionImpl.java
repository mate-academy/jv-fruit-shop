package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.GetterFruitTransaction;

public class GetterFruitTransactionImpl implements GetterFruitTransaction {
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_fruitName = 1;
    private static final int INDEX_OF_quantity = 2;

    @Override
    public FruitTransaction getFruitTransaction(String[] transaction) {
        return new FruitTransaction(transaction[INDEX_OF_OPERATION],
                transaction[INDEX_OF_fruitName], Integer.parseInt(transaction[INDEX_OF_quantity]));
    }
}
