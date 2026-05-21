package service;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;

public class DataConverterImpl implements DataConverter {
    private static final String SEPARATOR = ",";
    private static final int FIRST_DATA_LINE_INDEX = 1;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int PARTS_COUNT = 3;

    @Override
    public List<FruitTransaction> convert(List<String> inputReport) {
        if (inputReport == null) {
            throw new RuntimeException("Input report can't be null");
        }

        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = FIRST_DATA_LINE_INDEX; i < inputReport.size(); i++) {
            String line = inputReport.get(i);
            if (line == null || line.isBlank()) {
                continue;
            }

            String[] parts = line.split(SEPARATOR, -1);
            if (parts.length != PARTS_COUNT) {
                throw new RuntimeException("Invalid data in line: " + line);
            }

            FruitTransaction.Operation operation = getOperation(parts[OPERATION_INDEX].trim());
            String fruit = parts[FRUIT_INDEX].trim();
            int quantity = getQuantity(parts[QUANTITY_INDEX].trim(), line);

            if (fruit.isBlank()) {
                throw new RuntimeException("Fruit name can't be blank in line: " + line);
            }
            if (quantity < 0) {
                throw new RuntimeException("Quantity can't be negative in line: " + line);
            }

            FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
            transactions.add(transaction);
        }

        return transactions;
    }

    private FruitTransaction.Operation getOperation(String code) {
        for (FruitTransaction.Operation operation : FruitTransaction.Operation.values()) {
            if (operation.getCode().equals(code)) {
                return operation;
            }
        }

        throw new RuntimeException("Unknown operation code: " + code);
    }

    private int getQuantity(String value, String line) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid quantity in line: " + line, e);
        }
    }
}
