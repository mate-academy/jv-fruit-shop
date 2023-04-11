package core.basesyntax.function.impl;

import core.basesyntax.model.FruitTransaction;
import java.util.function.Function;

public class StringToTransactionConverter implements Function<String, FruitTransaction> {

    public static final String TRANSACTION_SEPARATOR = ",";
    public static final int TRANSACTION_INDEX = 0;
    public static final int FRUIT_INDEX = 1;
    public static final int QUANTITY_INDEX = 2;

    @Override
    public FruitTransaction apply(String stringFruitTransaction) {
        String[] strings = stringFruitTransaction.split(TRANSACTION_SEPARATOR);
        return new FruitTransaction(strings[TRANSACTION_INDEX], strings[FRUIT_INDEX],
                        strings[QUANTITY_INDEX]);
    }
}
