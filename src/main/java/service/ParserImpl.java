package service;

import dto.ShopOperation;

public class ParserImpl implements Parser {
    private static final String SEPARATOR = ",";
    private static final int OPERATION_IN_ARRAY = 0;
    private static final int FRUIT_IN_ARRAY = 1;
    private static final int AMOUNT_IN_ARRAY = 2;
    private static final int TOTAL_ELEMENTS = 3;

    @Override
    public ShopOperation parseLine(String line) {
        String[] splittedLine = line.split(SEPARATOR);
        if (splittedLine.length != TOTAL_ELEMENTS) {
            throw new RuntimeException("wrong input line");
        }
        String operation = splittedLine[OPERATION_IN_ARRAY];
        String fruit = splittedLine[FRUIT_IN_ARRAY];
        int amount;
        try {
            amount = Integer.parseInt(splittedLine[AMOUNT_IN_ARRAY]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Wrong fruit amount");
        }
        if (amount <= 0) {
            throw new RuntimeException("Wrong fruit amount");
        }
        return new ShopOperation(operation, fruit, amount);
    }
}
