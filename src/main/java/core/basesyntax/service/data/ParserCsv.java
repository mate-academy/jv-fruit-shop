package core.basesyntax.service.data;

import core.basesyntax.model.FruitTransaction;

public class ParserCsv implements Parser<FruitTransaction> {
    public static final int INDEX_OPERATION = 0;
    public static final int INDEX_FRUIT = 1;
    public static final int INDEX_QUANTITY = 2;

    @Override
    public FruitTransaction parser(String row) {

        String[] fields = row.split(",");
        return new FruitTransaction(fields[INDEX_OPERATION], fields[INDEX_FRUIT],
                Integer.parseInt(fields[INDEX_QUANTITY]));
    }
}
