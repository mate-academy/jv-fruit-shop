package core.basesyntax.utils;

import core.basesyntax.model.FruitTransaction;

public class CsvParserUtil {
    private static final String INVALID_LINE_FORMAT = "The line has wrong format";
    private static final String SEPARATOR = ",";
    private static final int CSV_COLUMN_COUNT = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    public FruitTransaction extractTransaction(String line) {
        String[] lineArray = line.split(SEPARATOR);

        if (lineArray.length != CSV_COLUMN_COUNT) {
            throw new RuntimeException(INVALID_LINE_FORMAT);
        }

        String symbol = lineArray[OPERATION_INDEX].trim();
        String fruit = lineArray[FRUIT_INDEX].trim();
        int quantity = Integer.parseInt(lineArray[QUANTITY_INDEX].trim());
        return new FruitTransaction(getOperation(symbol), fruit, quantity);
    }

    private FruitTransaction.Operation getOperation(String symbol) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getOperation().equals(symbol)) {
                return operation;
            }
        }
        return null;
    }
}
