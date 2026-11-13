package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;

import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> input) {
        if (input == null) {
            throw new IllegalArgumentException("Input cannot be null");
        }

        if (input.isEmpty()) {
            throw new IllegalArgumentException("Input cannot be empty");
        }

        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = 1; i < input.size(); i++) {
            String line = input.get(i);

            if (line == null || line.isBlank()) {
                throw new IllegalArgumentException(
                        "Empty line at index: " + i);
            }

            String[] parts = line.split(",", -1);

            if (parts.length != 3) {
                throw new IllegalArgumentException(
                        "Invalid CSV format at line: " + (i + 1));
            }

            String operationCode = parts[0].trim();
            String fruit = parts[1].trim();
            String quantityValue = parts[2].trim();

            if (fruit.isEmpty()) {
                throw new IllegalArgumentException(
                        "Fruit cannot be empty at line: " + (i + 1));
            }

            if (quantityValue.isEmpty()) {
                throw new IllegalArgumentException(
                        "Quantity cannot be empty at line: " + (i + 1));
            }

            FruitTransaction.Operation operation =
                    FruitTransaction.Operation.getOperationByCode(
                            operationCode);

            int quantity;

            try {
                quantity = Integer.parseInt(quantityValue);
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException(
                        "Invalid quantity at line: " + (i + 1), e);
            }

            if (quantity < 0) {
                throw new IllegalArgumentException(
                        "Quantity cannot be negative at line: " + (i + 1));
            }

            transactions.add(
                    new FruitTransaction(operation, fruit, quantity));
        }

        return transactions;
    }
}
