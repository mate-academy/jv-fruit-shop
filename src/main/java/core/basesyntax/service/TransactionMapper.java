package core.basesyntax.service;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.util.CsvRowValidator;
import java.util.function.Function;

public class TransactionMapper implements Function<String, FruitTransaction> {
    private static final String SEPARATOR = ",";
    private static final int NUMBER_OF_COLUMNS = 3;
    private static final int OPERATION_TYPE_COLUMN = 0;
    private static final int FRUIT_TYPE_COLUMN = 1;
    private static final int OPERATION_VALUE_COLUMN = 2;

    @Override
    public FruitTransaction apply(String row) {
        CsvRowValidator.validate(row, NUMBER_OF_COLUMNS);
        String[] columns = row.split(SEPARATOR);
        int operationValue = Integer.parseInt(columns[OPERATION_VALUE_COLUMN])
                * TransactionValueCalculator
                .calculateTransactionValue(columns[OPERATION_TYPE_COLUMN]);
        return new FruitTransaction(columns[FRUIT_TYPE_COLUMN], operationValue);
    }
}
