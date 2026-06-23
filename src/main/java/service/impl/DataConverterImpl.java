package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int EXPECTED_PARTS = 3;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        if (data == null || data.isEmpty()) {
            throw new RuntimeException("Input data is null or empty");
        }
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < data.size(); i++) {
            String line = data.get(i);
            String[] parts = line.split(",");
            if (parts.length < EXPECTED_PARTS) {
                throw new RuntimeException("Invalid data in line: " + line);
            }
            FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(parts[OPERATION_INDEX].toLowerCase());
            String fruit = parts[FRUIT_INDEX];
            int quantity;
            try {
                quantity = Integer.parseInt(parts[QUANTITY_INDEX]);
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid quantity in line: " + line, e);
            }
            if (quantity < 0) {
                throw new RuntimeException("Negative quantity in line: " + line);
            }
            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }
        return transactions;
    }
}
