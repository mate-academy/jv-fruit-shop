package service.impl;

import model.FruitTransaction;
import service.FruitDao;

public class FruitDaoImpl implements FruitDao {
    private static final String COMMA = ",";

    @Override
    public FruitTransaction getFromCsvData(String line) {
        if (line == null || line.isEmpty()) {
            throw new RuntimeException("Line cannot be null or empty");
        }

        String[] fields = line.split(COMMA);
        if (fields.length != 3) {
            throw new RuntimeException("Invalid CSV line (expected 3 fields): '" + line + "'");
        }

        FruitTransaction fruitTransaction = new FruitTransaction();

        try {
            fruitTransaction.setOperation(FruitTransaction.Operation.fromCode(fields[0]));
        } catch (Exception e) {
            throw new RuntimeException("Invalid operation code in line: '" + line + "'", e);
        }

        fruitTransaction.setFruit(fields[1]);

        int quantity;
        try {
            quantity = Integer.parseInt(fields[2]);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid quantity in line: '" + line + "'", e);
        }

        if (quantity < 0) {
            throw new RuntimeException("Quantity cannot be negative in line: '" + line + "'");
        }

        fruitTransaction.setQuantity(quantity);
        return fruitTransaction;
    }
}
