package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String CSV_SEPARATOR = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int EXPECTED_COLUMN_COUNT = 3;
    private static final int FRUIT_NAME_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> reportData) {
        if (reportData == null) {
            throw new RuntimeException("Input data list cannot be null");
        }
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = 1; i < reportData.size(); i++) {
            String line = reportData.get(i);
            if (line == null || line.trim().isEmpty()) {
                throw new RuntimeException("Input line is empty or null");
            }
            String[] valuesArray = line.split(CSV_SEPARATOR);
            if (valuesArray.length != EXPECTED_COLUMN_COUNT) {
                throw new RuntimeException("Invalid CSV line at row " + i + ": " + line);
            }
            try {
                String operationCode = valuesArray[OPERATION_INDEX].trim();
                String fruit = valuesArray[FRUIT_NAME_INDEX].trim();
                String quantityStr = valuesArray[QUANTITY_INDEX].trim();

                if (operationCode.isEmpty() || fruit.isEmpty()) {
                    throw new RuntimeException("Operation or fruit name is empty at row " + i);
                }

                FruitTransaction.Operation operation = FruitTransaction.Operation
                        .getByCode(operationCode);
                int quantity = Integer.parseInt(quantityStr);
                if (quantity < 0) {
                    throw new RuntimeException("Quantity cannot be negative at row "
                            + i + ": " + quantity);
                }

                transactions.add(new FruitTransaction(operation, fruit, quantity));
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid quantity format at row " + i + ": " + line, e);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Unknown operation code at row " + i + ": " + line, e);
            }
        }
        return transactions;
    }
}
