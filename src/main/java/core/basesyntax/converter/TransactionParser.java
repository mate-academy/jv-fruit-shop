package core.basesyntax.converter;

import core.basesyntax.model.FruitTransaction;
import java.util.function.Function;

public class TransactionParser implements Function<String, FruitTransaction> {
    public static final String COMMA = ",";
    public static final int OPERATION_POSITION = 0;
    public static final int FRUIT_POSITION = 1;
    public static final int QUANTITY_POSITION = 2;

    @Override
    public FruitTransaction apply(String transaction) {
        String[] fields = transaction.split(COMMA);
        return new FruitTransaction(
                FruitTransaction.Operation.fromCode(fields[OPERATION_POSITION].trim()),
                fields[FRUIT_POSITION],
                Integer.parseInt(fields[QUANTITY_POSITION])
        );
    }
}
