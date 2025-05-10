package core.basesyntax.service.impl;

import core.basesyntax.model.OperationType;
import core.basesyntax.model.impl.FruitTransaction;
import core.basesyntax.service.TransactionParser;
import core.basesyntax.service.util.CsvRowValidator;

public class FruitTransactionParser implements TransactionParser<FruitTransaction> {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_TYPE_COLUMN = 0;
    private static final int PRODUCT_TYPE_COLUMN = 1;
    private static final int OPERATION_VALUE_COLUMN = 2;

    @Override
    public FruitTransaction parse(String row) {
        if (!CsvRowValidator.validate(row)) {
            throw new RuntimeException("Invalid data in row: " + row
            + " The expected format should be: b,apple,100");
        }
        String[] columns = row.split(SEPARATOR);
        return new FruitTransaction(OperationType
                .getByCode(columns[OPERATION_TYPE_COLUMN]),
                columns[PRODUCT_TYPE_COLUMN],
                Integer.parseInt(columns[OPERATION_VALUE_COLUMN]));
    }
}
