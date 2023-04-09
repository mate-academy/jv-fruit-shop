package core.basesyntax.function.impl;

import core.basesyntax.model.FruitTransaction;
import java.util.function.Function;

public class StringToFruitTransaction implements Function<String,FruitTransaction> {

    public static final String TRANSACTION_STRING_SEPARATOR = ",";
    public static final int TRANSACTION = 0;
    public static final int FRUIT = 1;
    public static final int QUANTITY = 2;

    @Override
    public FruitTransaction apply(String stringFruitTransaction) {
        String[] strings = stringFruitTransaction.split(TRANSACTION_STRING_SEPARATOR);
        FruitTransaction fruitTransaction =
                new FruitTransaction(strings[TRANSACTION],strings[FRUIT],strings[QUANTITY]);
        return fruitTransaction;
    }
}
