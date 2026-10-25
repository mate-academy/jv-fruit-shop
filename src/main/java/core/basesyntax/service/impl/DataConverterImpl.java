package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String SEPARATOR = ",";
    private static final int HEADER_INDEX = 0;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int PARTS_COUNT = 3;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();

        for (int i = HEADER_INDEX + 1; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line.isBlank()) {
                continue;
            }
            FruitTransaction transaction = parseLine(line);
            transactions.add(transaction);
        }

        return transactions;
    }

    private FruitTransaction parseLine(String line) {
        String trimmedLine = line.trim();
        String[] parts = trimmedLine.split(SEPARATOR);

        if (parts.length != PARTS_COUNT) {
            throw new IllegalArgumentException("Invalid line format: " + line);
        }

        String operationCode = parts[OPERATION_INDEX].trim();
        String fruit = parts[FRUIT_INDEX].trim();
        String quantityText = parts[QUANTITY_INDEX].trim();

        FruitTransaction.Operation operation = FruitTransaction.Operation.fromCode(operationCode);
        int quantity = parseQuantity(quantityText, line);

        return new FruitTransaction(operation, fruit, quantity);
    }

    private int parseQuantity(String quantityText, String line) {
        int quantity;
        try {
            quantity = Integer.parseInt(quantityText);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Quantity is not a number in line: " + line, e);
        }

        if (quantity < 0) {
            throw new IllegalArgumentException("Quantity can't be negative in line: " + line);
        }
        return quantity;
    }
}
