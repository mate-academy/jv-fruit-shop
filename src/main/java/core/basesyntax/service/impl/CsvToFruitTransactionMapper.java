package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.Mapper;

public class CsvToFruitTransactionMapper implements Mapper<String, FruitTransaction> {
    private final int OPERATION_CODE_COLUMN;
    private final int FRUIT_COLUMN;
    private final int AMOUNT_COLUMN;
    private final String STRING_SEPARATOR;

    public CsvToFruitTransactionMapper(int operationCodeColumn, int fruitColumn, int amountColumn, String stringSeparator) {
        OPERATION_CODE_COLUMN = operationCodeColumn;
        FRUIT_COLUMN = fruitColumn;
        AMOUNT_COLUMN = amountColumn;
        STRING_SEPARATOR = stringSeparator;
    }

    @Override
    public FruitTransaction map(String from) {
        final String[] parsed = from.split(STRING_SEPARATOR);
        return new FruitTransaction(
                parsed[OPERATION_CODE_COLUMN],
                parsed[FRUIT_COLUMN],
                Integer.parseInt(parsed[AMOUNT_COLUMN]));
    }
}
