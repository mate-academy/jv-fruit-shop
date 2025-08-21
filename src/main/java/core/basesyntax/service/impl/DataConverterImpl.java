package core.basesyntax.service.impl;

import core.basesyntax.model.FruitTransaction;
import core.basesyntax.service.DataConverter;
import java.util.ArrayList;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int HEADER_INDEX = 1;
    private static final int EXPECTED_PARTS_COUNT = 3;
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int MIN_QUANTITY = 0;
    private static final char COMMA = ',';

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> lines) {
        List<FruitTransaction> transactions = new ArrayList<>();
        for (int i = HEADER_INDEX; i < lines.size(); i++) {
            String line = lines.get(i);
            try {
                String[] parts = line.split("COMMA");
                if (parts.length != EXPECTED_PARTS_COUNT) {
                    throw new RuntimeException("Invalid line format: " + line);
                }
                FruitTransaction.Operation operation =
                        FruitTransaction.Operation.fromCode(parts[OPERATION_INDEX]);
                String fruit = parts[FRUIT_INDEX];
                if (fruit == null || fruit.isEmpty()) {
                    throw new RuntimeException(
                            "Fruit name cannot be null or empty in line: " + line);
                }
                int quantity = Integer.parseInt(parts[QUANTITY_INDEX]);
                if (quantity < MIN_QUANTITY) {
                    throw new RuntimeException(
                            "Quantity cannot be negative in line: " + line);
                }
                transactions.add(new FruitTransaction(operation, fruit, quantity));
            } catch (NumberFormatException e) {
                throw new RuntimeException("Invalid quantity format in line: " + line, e);
            } catch (IllegalArgumentException e) {
                throw new RuntimeException("Invalid operation in line: " + line, e);
            }
        }
        return transactions;
    }
}
