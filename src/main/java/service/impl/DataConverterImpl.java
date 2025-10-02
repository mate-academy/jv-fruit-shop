package service.impl;

import java.util.ArrayList;
import java.util.List;
import model.FruitTransaction;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransactions(List<String> lines) {
        if (lines == null || lines.size() < 2) {
            throw new IllegalArgumentException(
                    "File must contain header and at least one data line");
        }

        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            if (line.isEmpty()) {
                continue;
            }

            String[] parts = line.split(",");
            if (parts.length != 3) {
                throw new IllegalArgumentException(
                        "Invalid line at index " + i + ": " + line);
            }

            final FruitTransaction.Operation operation =
                    FruitTransaction.Operation.fromCode(parts[0].trim());
            final String fruit = parts[1].trim();
            if (fruit.isEmpty()) {
                throw new IllegalArgumentException(
                        "Fruit name cannot be empty at line: " + line);
            }

            int quantity;
            try {
                quantity = Integer.parseInt(parts[2].trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(
                        "Invalid quantity at line: " + line, e);
            }

            if (quantity < 0) {
                throw new IllegalArgumentException(
                        "Quantity cannot be negative at line: " + line);
            }

            transactions.add(new FruitTransaction(operation, fruit, quantity));
        }

        return transactions;
    }
}
