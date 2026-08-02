package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String CSV_SEPARATOR = ",";
    private static final int HEADER_ROW_COUNT = 1;
    private static final int EXPECTED_COLUMN_COUNT = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> inputReport) {
        if (inputReport == null) {
            throw new IllegalArgumentException("Input report cannot be null");
        }
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = HEADER_ROW_COUNT; i < inputReport.size(); i++) {
            String line = inputReport.get(i);
            if (line == null) {
                throw new IllegalArgumentException("Input line cannot be null: " + (i + 1));
            }
            if (!line.isBlank()) {
                transactions.add(parseTransaction(line, i + 1));
            }
        }
        return transactions;
    }

    private FruitTransaction parseTransaction(String line, int lineNumber) {
        String[] values = line.split(CSV_SEPARATOR, -1);
        if (values.length != EXPECTED_COLUMN_COUNT) {
            throw new RuntimeException("Invalid CSV data at line " + lineNumber + ": " + line);
        }
        FruitTransaction.Operation operation = FruitTransaction.Operation.getByCode(
                values[OPERATION_INDEX].trim()
        );
        String fruit = values[FRUIT_INDEX].trim();
        int quantity = parseQuantity(values[QUANTITY_INDEX].trim(), lineNumber);
        return new FruitTransaction(operation, fruit, quantity);
    }

    private int parseQuantity(String value, int lineNumber) {
        try {
            int quantity = Integer.parseInt(value);
            if (quantity < 0) {
                throw new RuntimeException("Quantity cannot be negative at line " + lineNumber);
            }
            return quantity;
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid quantity at line " + lineNumber + ": " + value, e);
        }
    }
}
