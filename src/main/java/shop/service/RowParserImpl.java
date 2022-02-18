package shop.service;

import shop.impl.FruitTransaction;

public class RowParserImpl implements RowParser {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_IN_ARRAY = 0;
    private static final int FRUIT_IN_ARRAY = 1;
    private static final int AMOUNT_IN_ARRAY = 2;
    private static final int TOTAL_ELEMENTS = 3;

    @Override
    public FruitTransaction parseLine(String line) {
        String[] splitterLine = line.split(SEPARATOR);
        if (splitterLine.length != TOTAL_ELEMENTS) {
            throw new RuntimeException("Wrong input line");
        }
        String operation = splitterLine[OPERATION_IN_ARRAY];
        String fruit = splitterLine[FRUIT_IN_ARRAY];
        int amount;
        try {
            amount = Integer.parseInt(splitterLine[AMOUNT_IN_ARRAY]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Wrong fruit amount");
        }
        if (amount <= 0) {
            throw new RuntimeException("Wrong fruit amount");
        }
        return new FruitTransaction(operation, fruit, amount);
    }
}
