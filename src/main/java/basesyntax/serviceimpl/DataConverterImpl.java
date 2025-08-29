package basesyntax.serviceimpl;

import basesyntax.common.FruitTransaction;
import basesyntax.service.DataConverter;
import java.util.List;

public class DataConverterImpl implements DataConverter {
    private static final int VALID_COLUMN_COUNT = 3;
    private static final int OPERATION_COLUMN = 0;
    private static final int FRUIT_COLUMN = 1;
    private static final int QUANTITY_COLUMN = 2;
    private static final String CSV_DELIMITER = ",";

    @Override
    public List<FruitTransaction> convertToTransaction(List<String> rawData) {
        return rawData.stream()
                .skip(1)
                .map(line -> {
                    String[] parts = line.split(CSV_DELIMITER);
                    if (parts.length != VALID_COLUMN_COUNT) {
                        throw new RuntimeException("Invalid number of columns per row: '"
                                + line + "'");
                    }
                    String fruitName = parts[FRUIT_COLUMN].trim();
                    if (fruitName.isBlank()) {
                        throw new RuntimeException("Fruit name cannot be empty in string: '"
                                + line + "'");
                    }
                    String operationCode = parts[OPERATION_COLUMN].trim();
                    int quantity;
                    try {
                        quantity = Integer.parseInt(parts[QUANTITY_COLUMN].trim());
                    } catch (NumberFormatException e) {
                        throw new RuntimeException("Invalid quantity format in line: '"
                                + line + "'", e);
                    }
                    if (quantity < 0) {
                        throw new RuntimeException("Quantity cannot be negative in a string: '"
                                + line + "'");
                    }
                    return new FruitTransaction(
                            FruitTransaction.Operation.fromCode(operationCode),
                            fruitName,
                            quantity
                    );
                })
                .toList();
    }
}
