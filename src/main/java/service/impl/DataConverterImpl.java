package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.Operation;
import service.DataConverter;

class DataConverterImpl implements DataConverter {
    private static final String SEPARATOR = ",";
    private static final int PARTS_COUNT = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(SEPARATOR);
            if (parts.length != PARTS_COUNT) {
                throw new IllegalArgumentException("Invalid input line: " + line);
            }
            Operation operation = Operation.fromCode(parts[OPERATION_INDEX]);
            String fruit = parts[FRUIT_INDEX];
            int quantity;
            try {
                quantity = Integer.parseInt(parts[QUANTITY_INDEX]);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Invalid quantity: "
                        + parts[2] + " in line: " + line, e);
            }
            FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
            transactions.add(transaction);
        }
        return transactions;
    }
}
