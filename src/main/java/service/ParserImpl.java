package service;

import dto.ShopOperation;

public class ParserImpl implements Parser {
    private static final String REGEX = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int AMOUNT_INDEX = 2;
    private static final int LINE_ELEMENTS_NUMBER = 3;

    @Override
    public ShopOperation parseLine(String line) {
        String[] splittedLine = line.split(REGEX);
        if (splittedLine.length != LINE_ELEMENTS_NUMBER) {
            throw new RuntimeException("wrong input line");
        }
        String operation = splittedLine[OPERATION_INDEX];
        String fruit = splittedLine[FRUIT_INDEX];
        int amount;
        try {
            amount = Integer.parseInt(splittedLine[AMOUNT_INDEX]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Wrong fruit amount");
        }
        if (amount < 0) {
            throw new RuntimeException("Wrong fruit amount");
        }
        return new ShopOperation(operation, fruit, amount);
    }
}
