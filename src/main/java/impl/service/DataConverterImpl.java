package impl.service;

import java.util.List;
import java.util.Objects;
import model.FruitTransaction;
import service.DataConverter;

public class DataConverterImpl implements DataConverter {
    private static final String CSV_DELIMITER = ",";
    private static final int OPERATION_INDEX = 0;
    private static final int FRUIT_INDEX = 1;
    private static final int QUANTITY_INDEX = 2;
    private static final int EXPECTED_PARTS_COUNT = 3;

    @Override
    public List<FruitTransaction> convert(List<String> lines) {
        if (lines == null) {
            throw new RuntimeException("Input lines cannot be null");
        }
        return lines.stream()
                .filter(Objects::nonNull)
                .map(this::parseLine)
                .toList();
    }

    private FruitTransaction parseLine(String line) {
        String[] parts = line.split(CSV_DELIMITER);
        if (parts.length != EXPECTED_PARTS_COUNT) {
            throw new RuntimeException("Invalid CSV line format: "
                    + line);
        }
        try {
            FruitTransaction.Operation operation = FruitTransaction
                    .Operation.getByCode(parts[OPERATION_INDEX]);
            String fruit = parts[FRUIT_INDEX];
            int quantity = Integer.parseInt(parts[QUANTITY_INDEX]);
            if (quantity < 0) {
                throw new RuntimeException("Quantity cannot be negative: "
                        + quantity);
            }
            return new FruitTransaction(operation, fruit, quantity);
        } catch (NumberFormatException e) {
            throw new RuntimeException("Invalid quantity format in line: "
                    + line, e);
        }
    }
}
