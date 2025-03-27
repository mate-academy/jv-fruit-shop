package service.impl;

import model.FruitTransaction;
import model.FruitTransaction.Operation;
import service.ParseService;

public class ParseServiceImpl implements ParseService {
    private static final String SEPARATION = ",";
    private static final int INDEX = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;
    private static final int FIELDS_LENGTH = 3;

    private static final String LINE_EMPTY = "Input line cannot be null or empty";
    private static final String LINE_LENGTH = "Invalid CSV format: expected 3 fields, but got ";
    private static final String LINE = " in line: ";
    private static final String OPERATION_CODE = "Invalid operation code";
    private static final String FRUIT_NAME = "Fruit name cannot be empty";
    private static final String INVALID_QUANTITY_FORMAT = "Invalid quantity format";
    private static final String NEGATIVE_QUANTITY = "Quantity cannot be negative";

    private FruitTransaction parseCsvLine(String line) {
        if (line == null || line.trim().isEmpty()) {
            throw new IllegalArgumentException(LINE_EMPTY);
        }

        String[] fields = line.split(SEPARATION);
        if (fields.length != FIELDS_LENGTH) {
            throw new IllegalArgumentException(LINE_LENGTH + fields.length + LINE + line);
        }

        FruitTransaction fruitTransaction = new FruitTransaction();
        try {
            fruitTransaction.setOperation(Operation.fromCode(fields[INDEX]));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(OPERATION_CODE + LINE + line, e);
        }

        fruitTransaction.setFruit(fields[INDEX_FRUIT]);
        if (fields[INDEX_FRUIT].trim().isEmpty()) {
            throw new IllegalArgumentException(FRUIT_NAME + LINE + line);
        }

        try {
            fruitTransaction.setQuantity(Integer.parseInt(fields[INDEX_QUANTITY]));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(INVALID_QUANTITY_FORMAT + LINE + line, e);
        }

        if (fruitTransaction.getQuantity() < INDEX) {
            throw new IllegalArgumentException(NEGATIVE_QUANTITY + LINE + line);
        }
        return fruitTransaction;
    }

    @Override
    public FruitTransaction parseLine(String line) {
        return parseCsvLine(line);
    }
}
