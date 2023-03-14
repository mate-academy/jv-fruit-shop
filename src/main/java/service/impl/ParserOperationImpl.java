package service.impl;

import model.TransactionDto;
import service.ParserOperation;

public class ParserOperationImpl implements ParserOperation {
    private static final String SEPARATOR = ",";
    private static final int ZERO_INDEX = 0;
    private static final int FIRST_INDEX = 1;
    private static final int SECOND_INDEX = 2;

    @Override
    public TransactionDto parserOperation(String line) {
        String[] splitLine = line.split(SEPARATOR);
        if (splitLine.length < 3) {
            throw new IllegalArgumentException("Invalid input string format");
        }
        String operation = splitLine[ZERO_INDEX];
        String fruitName = splitLine[FIRST_INDEX];
        int quantity;
        try {
            quantity = Integer.parseInt(splitLine[SECOND_INDEX]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input string format, "
                    + "quantity is not a valid integer");
        }
        return new TransactionDto(operation, fruitName, quantity);
    }
}
