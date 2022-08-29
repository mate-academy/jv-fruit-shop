package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.TypeActivity;
import core.basesyntax.service.ParseFruitTransaction;

public class ParseFruitTransactionImpl implements ParseFruitTransaction {
    private static final int INDEX_CHAR_ACTIVITY = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_COUNT = 2;
    private static final String CSV_SEPARATOR = ",";

    @Override
    public FruitTransaction processing(String string) {
        String[] array = string.split(CSV_SEPARATOR);
        return new FruitTransaction(
                TypeActivity.getByLabel(array[INDEX_CHAR_ACTIVITY]),
                array[INDEX_FRUIT],
                Integer.parseInt(array[INDEX_COUNT])
        );
    }
}
