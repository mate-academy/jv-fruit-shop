package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.GetterFruitTransaction;

public class GetterFruitTransactionImpl implements GetterFruitTransaction {
    private static final int INDEX_OF_OPERATION = 0;
    private static final int INDEX_OF_FRUIT_NAME = 1;
    private static final int INDEX_OF_QUANTITY = 2;

    @Override
    public FruitTransaction getFruitTransaction(String[] transaction) {
        return new FruitTransaction(transaction[INDEX_OF_OPERATION],
                transaction[INDEX_OF_FRUIT_NAME], Integer.parseInt(transaction[INDEX_OF_QUANTITY]));
    }
}
