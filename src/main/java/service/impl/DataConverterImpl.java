package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import model.Operation;
import service.DataConverter;

class DataConverterImpl implements DataConverter {
    private static final String SEPARATOR = ",";
    private static final int PARTS_COUNT = 3;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : lines) {
            String[] parts = line.split(SEPARATOR);
            if (parts.length != PARTS_COUNT) {
                throw new IllegalArgumentException("Invalid input line: " + line);
            }
            Operation operation = Operation.fromCode(parts[0]);
            String fruit = parts[1];
            int quantity;
            try {
                quantity = Integer.parseInt(parts[2]);
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
