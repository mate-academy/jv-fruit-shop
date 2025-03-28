package service.impl;

import model.FruitTransaction;
import model.FruitTransaction.Operation;

public class ParseServiceImpl {
    private static final String SEPARATOR = ",";
    private static final int INDEX_OPERATION = 0;
    private static final int INDEX_FRUIT = 1;
    private static final int INDEX_QUANTITY = 2;
    private static final int FIELDS_LENGTH = 3;
    private static final int MIN_QUANTITY = 0;

    public FruitTransaction parseCsvLine(String line) {
        if (line == null || line.trim().isEmpty()) {
            throw new IllegalArgumentException("Input line cannot be null or empty");
        }

        String[] fields = line.split(SEPARATOR);
        if (fields.length != FIELDS_LENGTH) {
            throw new IllegalArgumentException("Invalid CSV format: expected 3 fields, but got "
                    + fields.length + " in line: " + line);
        }

        FruitTransaction fruitTransaction = new FruitTransaction();
        try {
            fruitTransaction.setOperation(Operation.fromCode(fields[INDEX_OPERATION]));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid operation code in line: " + line, e);
        }

        if (fields[INDEX_FRUIT].trim().isEmpty()) {
            throw new IllegalArgumentException("Fruit name cannot be empty in line: " + line);
        }
        fruitTransaction.setFruit(fields[INDEX_FRUIT]);

        if (fruitTransaction.getQuantity() < MIN_QUANTITY) {
            throw new IllegalArgumentException("Quantity cannot be negative in line: " + line);
        }

        try {
            fruitTransaction.setQuantity(Integer.parseInt(fields[INDEX_QUANTITY]));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid quantity format in line: " + line, e);
        }
        return fruitTransaction;
    }
}
