package core.basesyntax.parser.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.parser.TextLineParser;

public class CsvTextLineParser implements TextLineParser {
    private static final String INVALID_LINE_FORMAT = "The line has wrong format";
    private static final String SEPARATOR = ",";
    private static final int CSV_COLUMN_COUNT = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final String BALANCE_SYMBOL = "b";
    private static final String SUPPLY_SYMBOL = "s";
    private static final String PURCHASE_SYMBOL = "p";
    private static final String RETURN_SYMBOL = "r";

    @Override
    public FruitTransaction extractOperationType(String line) {
        String[] lineArray = line.split(SEPARATOR);

        if (lineArray.length != CSV_COLUMN_COUNT) {
            throw new RuntimeException(INVALID_LINE_FORMAT);
        }

        FruitTransaction.Operation operation;
        String fruit = lineArray[FRUIT_INDEX];
        int quantity = Integer.parseInt(lineArray[QUANTITY_INDEX]);

        switch (lineArray[OPERATION_INDEX]) {
            case BALANCE_SYMBOL:
                operation = FruitTransaction.Operation.BALANCE;
                break;
            case SUPPLY_SYMBOL:
                operation = FruitTransaction.Operation.SUPPLY;
                break;
            case PURCHASE_SYMBOL:
                operation = FruitTransaction.Operation.PURCHASE;
                break;
            case RETURN_SYMBOL:
                operation = FruitTransaction.Operation.RETURN;
                break;
            default: operation = null;
        }
        return new FruitTransaction(operation, fruit, quantity);
    }
}
