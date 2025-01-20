package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final String COMMA = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> data) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (String line : data) {
            if (line == null || line.isEmpty()) {
                System.err.println("Skipping empty or null line");
                continue;
            }
            try {
                String[] parts = line.split(COMMA);
                if (parts.length != 3) {
                    throw new IllegalArgumentException("Invalid data format: " + line);
                }
                FruitTransaction.Operation operation
                        = FruitTransaction.Operation.fromCode(parts[OPERATION_INDEX]);
                String fruit = parts[FRUIT_INDEX];
                int quantity = Integer.parseInt(parts[QUANTITY_INDEX]);

                if (operation == null || fruit == null) {
                    System.err.println("Null values found in line: " + line);
                    continue;
                }

                FruitTransaction transaction = new FruitTransaction(operation, fruit, quantity);
                transactions.add(transaction);
            } catch (NumberFormatException e) {
                System.err.println("Invalid number format in line: " + line);
            } catch (IllegalArgumentException e) {
                System.err.println("Error processing line: " + line + " - " + e.getMessage());
            }
        }
        return transactions;
    }
}
